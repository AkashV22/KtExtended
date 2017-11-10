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

import kotlin.js.Date

fun Date.getDate(): Int = this.asDynamic().getDate() as Int

fun Date.getDay(): Int = this.asDynamic().getDay() as Int

fun Date.getFullYear(): Int = this.asDynamic().getFullYear() as Int

fun Date.getHours(): Int = this.asDynamic().getHours() as Int

fun Date.getMilliseconds(): Int = this.asDynamic().getMilliseconds() as Int

fun Date.getMinutes(): Int = this.asDynamic().getMinutes() as Int

fun Date.getMonth(): Int = this.asDynamic().getMonth() as Int

fun Date.getSeconds(): Int = this.asDynamic().getSeconds() as Int

fun Date.getTimezoneOffset(): Int = this.asDynamic().getTimezoneOffset() as Int

fun Date.getUTCDate(): Int = this.asDynamic().getUTCDate() as Int

fun Date.getUTCDay(): Int = this.asDynamic().getUTCDay() as Int

fun Date.getUTCFullYear(): Int = this.asDynamic().getUTCFullYear() as Int

fun Date.getUTCHours(): Int = this.asDynamic().getUTCHours() as Int

fun Date.getUTCMilliseconds(): Int = this.asDynamic().getUTCMilliseconds() as Int

fun Date.getUTCMinutes(): Int = this.asDynamic().getUTCMinutes() as Int

fun Date.getUTCMonth(): Int = this.asDynamic().getUTCMonth() as Int

fun Date.getUTCSeconds(): Int = this.asDynamic().getUTCSeconds() as Int

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