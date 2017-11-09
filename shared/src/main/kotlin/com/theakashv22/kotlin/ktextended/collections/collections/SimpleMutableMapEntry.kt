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

package com.theakashv22.kotlin.ktextended.collections.collections

open class SimpleMutableMapEntry<K, V>(key: K, value: V): SimpleMapEntry<K, V>(key, value),
        MutableMap.MutableEntry<K, V> {
    constructor(entry: Map.Entry<K, V>): this(entry.key, entry.value)
    private var _value: V = value

    override val value: V
        get() = _value

    override fun setValue(newValue: V): V {
        val oldValue: V = this._value
        this._value = newValue
        return oldValue
    }
}