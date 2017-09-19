package com.github.akashv22.kotlin.ktextended.collections

open header class SimpleMapEntry<K, V>: Map.Entry<K, V> {
    constructor(key: K, value: V)
    constructor(entry: Map.Entry<K, V>)

    override val key: K
    override val value: V
}