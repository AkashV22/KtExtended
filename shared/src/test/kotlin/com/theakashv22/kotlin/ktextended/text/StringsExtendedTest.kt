/*
 * Copyright (c) 2018 AkashV22
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

package com.theakashv22.kotlin.ktextended.text

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringsExtendedTest {
    // Tests for CharSequence?.isNotNullOrBlank()

    @Test
    fun testIsNotNullOrBlankFunctionReturnsTrueIfStringHasACharacter() = assertTrue("A".isNotNullOrBlank())

    @Test
    fun testIsNotNullOrBlankFunctionReturnsTrueIfStringHasCharacters() = assertTrue(" AB C ".isNotNullOrBlank())

    @Test
    fun testIsNotNullOrBlankFunctionReturnsFalseIfStringIsNull() = assertFalse(null.isNotNullOrBlank())

    @Test
    fun testIsNotNullOrBlankFunctionReturnsFalseIfStringIsEmpty() = assertFalse("".isNotNullOrBlank())

    @Test
    fun testIsNotNullOrBlankFunctionReturnsFalseIfStringOnlyHasAWhitespace() = assertFalse(" ".isNotNullOrBlank())

    @Test
    fun testIsNotNullOrBlankFunctionReturnsFalseIfStringOnlyHasWhitespaces() = assertFalse("   ".isNotNullOrBlank())

    // Tests for CharSequence?.isNotNullOrEmpty()

    @Test
    fun testIsNotNullOrEmptyFunctionReturnsTrueIfStringHasACharacter() = assertTrue("A".isNotNullOrEmpty())

    @Test
    fun testIsNotNullOrEmptyFunctionReturnsTrueIfStringHasCharacters() = assertTrue(" AB C ".isNotNullOrEmpty())

    @Test
    fun testIsNotNullOrEmptyFunctionReturnsFalseIfStringIsNull() = assertFalse(null.isNotNullOrEmpty())

    @Test
    fun testIsNotNullOrEmptyFunctionReturnsFalseIfStringIsEmpty() = assertFalse("".isNotNullOrEmpty())

    @Test
    fun testIsNotNullOrEmptyFunctionReturnsTrueIfStringOnlyHasAWhitespace() = assertTrue(" ".isNotNullOrEmpty())

    @Test
    fun testIsNotNullOrEmptyFunctionReturnsTrueIfStringOnlyHasWhitespaces() = assertTrue("   ".isNotNullOrEmpty())

    // Tests for CharSequence?.toStringBuilder()

    @Test
    fun testToStringBuilderFunctionReturnsStringBuilderWithGivenString() {
        assertEquals(expected = "Team, unite up!", actual = "Team, unite up!".toStringBuilder().toString())
    }

    @Test
    fun testToStringBuilderFunctionReturnsStringBuilderWithGivenStringPlusAppendedString() {
        assertEquals(expected = "Team, unite up!", actual = "Team".toStringBuilder().append(", unite up!").toString())
    }

    @Test
    fun testToStringBuilderFunctionReturnsStringBuilderWithGivenStringPlusAppendedNull() {
        assertEquals(
                expected = "The billion dollar mistake is the creation of the null value.",
                actual = "The billion dollar mistake is the creation of the "
                        .toStringBuilder()
                        .append(null as CharSequence?)
                        .append(" value.")
                        .toString()
        )
    }
}