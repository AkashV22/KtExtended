package com.akashv22.kotlin.ktextended.collections

fun <T> Iterable<T>.getLastIndex(indexOrigin: Int = 0): Int = this.count() - 1 + indexOrigin

fun <T> Iterable<T>.isLastIndex(currentIndex: Int, indexOrigin: Int = 0): Boolean =
        currentIndex == this.getLastIndex(indexOrigin)

fun <K, V> IndexedValue<Map.Entry<K, V>>.toIndexedKeyValuePair(): IndexedKeyValuePair<K, V> {
    val (index: Int, entry: Map.Entry<K, V>) = this
    val (key: K, value: V) = entry
    return IndexedKeyValuePair(index, key, value)
}

fun <A, B> IndexedValue<Pair<A,B>>.toIndexedPair(): IndexedPair<A, B> {
    val (index: Int, pair: Pair<A, B>) = this
    val (first: A, second: B) = pair
    return IndexedPair(index, first, second)
}

fun <A, B, C> IndexedValue<Triple<A, B, C>>.toIndexedTriple(): IndexedTriple<A, B, C> {
    val (index: Int, triple: Triple<A, B, C>) = this
    val (first: A, second: B, third: C) = triple
    return IndexedTriple(index, first, second, third)
}

fun <T> Iterable<T>.withIndex(indexOrigin: Int): Iterable<IndexedValue<T>> = this.withIndexBase(indexOrigin) { it }

fun <K, V> Map<K, V>.withIndex(indexOrigin: Int = 0): Iterable<IndexedKeyValuePair<K, V>> =
        this.entries.withIndexAndKeyValuePair(indexOrigin)

fun <K, V> Iterable<Map.Entry<K, V>>.withIndexAndKeyValuePair(indexOrigin: Int = 0): Iterable<IndexedKeyValuePair<K, V>> =
        this.withIndexBase(indexOrigin) { it.toIndexedKeyValuePair() }

fun <A, B> Iterable<Pair<A, B>>.withIndexAndPair(indexOrigin: Int = 0): Iterable<IndexedPair<A, B>> =
        this.withIndexBase(indexOrigin) { it.toIndexedPair() }

fun <A, B, C> Iterable<Triple<A, B, C>>.withIndexAndTriple(indexOrigin: Int = 0): Iterable<IndexedTriple<A, B, C>> =
        this.withIndexBase(indexOrigin) { it.toIndexedTriple() }

private fun <T, R> Iterable<T>.withIndexBase(
        indexOrigin: Int, toIndexedValue: (indexedValue: IndexedValue<T>) -> R
): Iterable<R> = object: Iterable<R> {
    private val indexedIterable: Iterable<IndexedValue<T>> = this@withIndexBase.withIndex()

    override fun iterator(): Iterator<R> {
        return object: Iterator<R> {
            private val itr: Iterator<IndexedValue<T>> = indexedIterable.iterator()

            override fun next(): R {
                val indexedValue: IndexedValue<T> = itr.next()
                return toIndexedValue(indexedValue.copy(index = indexedValue.index + indexOrigin))
            }

            override fun hasNext(): Boolean = itr.hasNext()
        }
    }
}