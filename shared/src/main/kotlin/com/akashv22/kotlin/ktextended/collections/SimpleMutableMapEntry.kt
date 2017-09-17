package com.akashv22.kotlin.ktextended.collections

open header class SimpleMutableMapEntry<K, V>: SimpleMapEntry<K, V>, MutableMap.MutableEntry<K, V> {
    constructor(key: K, value: V)
    constructor(entry: Map.Entry<K, V>)

    override fun setValue(newValue: V): V
}