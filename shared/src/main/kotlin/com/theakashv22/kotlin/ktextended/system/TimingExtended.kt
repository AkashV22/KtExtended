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

package com.theakashv22.kotlin.ktextended.system

expect fun currentTimeMillis(): Long

expect inline fun measureTimeMillis(block: () -> Unit): Long

inline fun <T> measureTimeMillisAndGetResult(function: (startTime: Long) -> T): MillisAndResult<T> =
        measureTimeAndGetResult(
                { currentTimeMillis() }, { runTime: Long, result: T -> MillisAndResult<T>(runTime, result) }, function
        )

inline fun <T, R> measureTimeAndGetResult(
        currentTimeFn: () -> Long, resultDataFn: (runTime: Long, result: T) -> R, function: (startTime: Long) -> T
): R {
    val startTime: Long = currentTimeFn()
    val result: T = function(startTime)
    val endTime: Long = currentTimeFn()
    return resultDataFn(endTime - startTime, result)
}