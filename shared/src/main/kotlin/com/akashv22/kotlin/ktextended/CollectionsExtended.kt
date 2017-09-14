package com.akashv22.kotlin.ktextended

fun <T> Iterable<T>.getLastIndex(indexOrigin: Int = 0): Int = this.count() - 1 + indexOrigin

fun <T> Iterable<T>.isLastIndex(currentIndex: Int, indexOrigin: Int = 0): Boolean =
        currentIndex == this.getLastIndex(indexOrigin)

fun <K, V> IndexedValue<Map.Entry<K, V>>.toIndexedKeyValuePair(): IndexedKeyValuePair<K, V> {
    val (index: Int, entry: Map.Entry<K, V>) = this
    val (key: K, value: V) = entry
    return IndexedKeyValuePair(index, key, value)
}

fun <T> Iterable<T>.withIndex(indexOrigin: Int): Iterable<IndexedValue<T>> =
        this.withIndexBase(indexOrigin) { calculatedIndex: Int, value: T -> IndexedValue(calculatedIndex, value) }

fun <K, V> Map<K, V>.withIndex(indexOrigin: Int = 0): Iterable<IndexedKeyValuePair<K, V>> =
        this.entries.withIndexAndKeyValuePair()

fun <K, V> Set<Map.Entry<K, V>>.withIndexAndKeyValuePair(indexOrigin: Int = 0): Iterable<IndexedKeyValuePair<K, V>> =
        this.withIndexBase(indexOrigin) {
            calculatedIndex: Int, (key: K, value: V) -> IndexedKeyValuePair(calculatedIndex, key, value)
        }

private fun <T, R> Iterable<T>.withIndexBase(
        indexOrigin: Int, toIndexedValue: (calculatedIndex: Int, value: T) -> R
): Iterable<R> = object: Iterable<R> {
    private val indexedIterable: Iterable<IndexedValue<T>> = this@withIndexBase.withIndex()

    override fun iterator(): Iterator<R> {
        return object: Iterator<R> {
            private val itr: Iterator<IndexedValue<T>> = indexedIterable.iterator()

            override fun next(): R {
                val (index: Int, value: T) = itr.next()
                return toIndexedValue(index + indexOrigin, value)
            }

            override fun hasNext(): Boolean = itr.hasNext()
        }
    }
}