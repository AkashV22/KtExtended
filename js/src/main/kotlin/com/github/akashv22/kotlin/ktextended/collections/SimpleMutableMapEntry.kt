package com.github.akashv22.kotlin.ktextended.collections

open impl class SimpleMutableMapEntry<K, V>(key: K, value: V): SimpleMapEntry<K, V>(key, value),
        MutableMap.MutableEntry<K, V> {
    constructor(entry: Map.Entry<K, V>): this(entry.key, entry.value)
    private var _value: V = value

    override val value: V
        get() = _value

    impl override fun setValue(newValue: V): V {
        val oldValue: V = this._value
        this._value = newValue
        return oldValue
    }
}