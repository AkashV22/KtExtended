package com.akashv22.kotlin.ktextended.collections

fun <K, V> Map<K, V>.getLastIndex(indexOrigin: Int = 0): Int = this.entries.getLastIndex(indexOrigin)

fun <K, V> Map<K, V>.isLastIndex(currentIndex: Int, indexOrigin: Int = 0): Boolean =
        this.entries.isLastIndex(currentIndex, indexOrigin)

fun <K, V> IndexedValue<Map.Entry<K, V>>.toIndexedKeyValuePair(): IndexedKeyValuePair<K, V> {
    val (index: Int, entry: Map.Entry<K, V>) = this
    val (key: K, value: V) = entry
    return IndexedKeyValuePair(index, key, value)
}

fun <K, V> Map<K, V>.withIndex(indexOrigin: Int = 0): Iterable<IndexedKeyValuePair<K, V>> =
        this.entries.withIndexAndKeyValuePair(indexOrigin)

fun <K, V> Iterable<Map.Entry<K, V>>.withIndexAndKeyValuePair(indexOrigin: Int = 0): Iterable<IndexedKeyValuePair<K, V>> =
        this.withIndexBase(indexOrigin) { it.toIndexedKeyValuePair() }

fun <K, V> Map.Entry<K, V>.toEntry(): Map.Entry<K, V> = this.toSimpleEntry()

fun <K, V> Map.Entry<K, V>.toMutableEntry(): MutableMap.MutableEntry<K, V> = this.toSimpleMutableEntry()

fun <K, V> Map.Entry<K, V>.toSimpleEntry(): SimpleMapEntry<K, V> = simpleMapEntryOf(this)

fun <K, V> Map.Entry<K, V>.toSimpleMutableEntry(): SimpleMutableMapEntry<K, V> = simpleMutableMapEntryOf(this)

fun <K, V> mapEntryOf(key: K, value: V): Map.Entry<K, V> = simpleMapEntryOf(key, value)

fun <K, V> mutableMapEntryOf(key: K, value: V): MutableMap.MutableEntry<K, V> = simpleMutableMapEntryOf(key, value)

fun <K, V> simpleMapEntryOf(key: K, value: V): SimpleMapEntry<K, V> = SimpleMapEntry(key, value)

fun <K, V> simpleMapEntryOf(entry: Map.Entry<K, V>): SimpleMapEntry<K, V> = SimpleMapEntry(entry)

fun <K, V> simpleMutableMapEntryOf(key: K, value: V): SimpleMutableMapEntry<K, V> = SimpleMutableMapEntry(key, value)

fun <K, V> simpleMutableMapEntryOf(entry: Map.Entry<K, V>): SimpleMutableMapEntry<K, V> = SimpleMutableMapEntry(entry)