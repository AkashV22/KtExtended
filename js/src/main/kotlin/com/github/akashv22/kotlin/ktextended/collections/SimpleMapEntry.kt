package com.github.akashv22.kotlin.ktextended.collections

open impl class SimpleMapEntry<K, V>(impl override val key: K, impl override val value: V): Map.Entry<K, V> {
    constructor(entry: Map.Entry<K, V>): this(entry.key, entry.value)
}