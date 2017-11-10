/*
 * Copyright (c) 2017 AkashV22
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.theakashv22.kotlin.ktextended.collections

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