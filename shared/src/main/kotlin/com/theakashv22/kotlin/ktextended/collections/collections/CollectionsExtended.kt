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

fun <T> Iterable<T>.getLastIndex(indexOrigin: Int = 0): Int = this.count() - 1 + indexOrigin

fun <T> Iterable<T>.isLastIndex(currentIndex: Int, indexOrigin: Int = 0): Boolean =
        currentIndex == this.getLastIndex(indexOrigin)

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

fun <A, B> Iterable<Pair<A, B>>.withIndexAndPair(indexOrigin: Int = 0): Iterable<IndexedPair<A, B>> =
        this.withIndexBase(indexOrigin) { it.toIndexedPair() }

fun <A, B, C> Iterable<Triple<A, B, C>>.withIndexAndTriple(indexOrigin: Int = 0): Iterable<IndexedTriple<A, B, C>> =
        this.withIndexBase(indexOrigin) { it.toIndexedTriple() }

internal fun <T, R> Iterable<T>.withIndexBase(
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