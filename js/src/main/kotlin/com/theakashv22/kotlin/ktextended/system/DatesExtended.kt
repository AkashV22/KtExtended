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

import com.theakashv22.kotlin.ktextended.dynamic.asDynamicThenCast
import kotlin.js.Date

fun Date.getDate(): Int = asDynamicThenCast { it.getDate() }

fun Date.getDay(): Int = asDynamicThenCast { it.getDay() }

fun Date.getFullYear(): Int = asDynamicThenCast { it.getFullYear() }

fun Date.getHours(): Int = asDynamicThenCast { it.getHours() }

fun Date.getMilliseconds(): Int = asDynamicThenCast { it.getMilliseconds() }

fun Date.getMinutes(): Int = asDynamicThenCast { it.getMinutes() }

fun Date.getMonth(): Int = asDynamicThenCast { it.getMonth() }

fun Date.getSeconds(): Int = asDynamicThenCast { it.getSeconds() }

fun Date.getTimezoneOffset(): Int = asDynamicThenCast { it.getTimezoneOffset() }

fun Date.getUTCDate(): Int = asDynamicThenCast { it.getUTCDate() }

fun Date.getUTCDay(): Int = asDynamicThenCast { it.getUTCDay() }

fun Date.getUTCFullYear(): Int = asDynamicThenCast { it.getUTCFullYear() }

fun Date.getUTCHours(): Int = asDynamicThenCast { it.getUTCHours() }

fun Date.getUTCMilliseconds(): Int = asDynamicThenCast { it.getUTCMilliseconds() }

fun Date.getUTCMinutes(): Int = asDynamicThenCast { it.getUTCMinutes() }

fun Date.getUTCMonth(): Int = asDynamicThenCast { it.getUTCMonth() }

fun Date.getUTCSeconds(): Int = asDynamicThenCast { it.getUTCSeconds() }

@JsName("currentDate")
fun dateOf(): Date = Date()

@Suppress("UNUSED_PARAMETER")
@JsName("dateOfString")
fun dateOf(dateString: String): Date = js("new Date(dateString)") as Date

@Suppress("UNUSED_PARAMETER")
@JsName("dateOfMillis")
fun dateOf(milliseconds: Long): Date = js("new Date(milliseconds)") as Date

@Suppress("UNUSED_PARAMETER")
fun dateOf(
        year: Int, month: Int, date: Int = 1, hours: Int = 0, minutes: Int = 0, seconds: Int = 0, milliseconds: Int = 0
): Date = js("new Date(year, month, date, hours, minutes, seconds, milliseconds)") as Date

fun now(): Long = js("Date.now()") as Long

@Suppress("UNUSED_PARAMETER")
fun parse(dateString: String): Long = js("Date.parse(dateString)") as Long

@Suppress("UNUSED_PARAMETER")
fun utc(
        year: Int, month: Int = 0, date: Int = 1, hour: Int = 0, minute: Int = 0, second: Int = 0, millisecond: Int = 0
): Long = js("Date.UTC(year, month, date, hour, minute, second, millisecond)") as Long