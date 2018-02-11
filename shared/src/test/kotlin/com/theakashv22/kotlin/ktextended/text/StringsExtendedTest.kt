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
import kotlin.test.assertNotSame
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

    // Test for CharSequence?.toStringBuilder()

    @Test
    fun testToStringBuilderFunctionReturnsStringBuilderWithGivenString() {
        assertEquals(expected = "Team, unite up!", actual = "Team, unite up!".toStringBuilder().toString())
    }

    // Tests for Iterable<CharSequence>.trimAll()

    @Test
    fun testTrimAllFunctionTrimsAllSuppliedStrings() {
        val testData: List<String> = listOf(" a ", "b", " cde", "fgh ", "ijk", " lmn ", "o p", " q r", "s t ", " u v ")
        val expectedResult: List<String> = listOf("a", "b", "cde", "fgh", "ijk", "lmn", "o p", "q r", "s t", "u v")
        assertEquals(expected = expectedResult, actual = testData.trimAll())
    }

    @Test
    fun testTrimAllFunctionReturnsEmptyListIfGivenEmptyIterable() {
        assertEquals(expected = listOf<String>(), actual = setOf<String>().trimAll())
    }

    @Test
    fun testTrimAllFunctionReturnsNewList() {
        assertNotSame(illegal = listOf("a", "b", "c"), actual = listOf("a", "b", "c").trimAll())
    }

    // Tests for String.concat(String)

    @Test
    fun testConcatFunctionConcatenatesTwoStrings() {
        assertEquals(expected = "You're not Alexander!", actual = "You're not".concat(" Alexander!"))
    }

    @Test
    fun testConcatFunctionConcatenatesBlankStrings() = assertEquals(expected = "", actual = "".concat(""))

    @Test
    fun testConcatFunctionConcatenatesEmptyStringsWithWhitespace() {
        assertEquals(expected = "   ", actual = " ".concat("  "))
    }

    // Tests for String.toBoolean()

    @Test
    fun testToBooleanFunctionReturnsTrueForStringContainingTrueLowercase() = assertTrue("true".toBoolean())

    @Test
    fun testToBooleanFunctionReturnsTrueForStringContainingTrueUppercase() = assertTrue("TRUE".toBoolean())

    @Test
    fun testToBooleanFunctionReturnsTrueForStringContainingTrueMixedCase() = assertTrue("TrUe".toBoolean())

    @Test
    fun testToBooleanFunctionReturnsFalseForStringSurroundedWithWhitespace() = assertFalse(" true  ".toBoolean())

    @Test
    fun testToBooleanFunctionReturnsFalseForStringContainingFalse() = assertFalse("false".toBoolean())

    @Test
    fun testToBooleanFunctionReturnsFalseForStringContainingNonBooleanValue() = assertFalse("yes".toBoolean())

    // Tests for String.toCharArray()

    @Test
    fun testToCharArrayFunctionReturnsCharArrayContainingGivenString() {
        assertTrue(charArrayOf('A', 'w', 'e', 's', 'o', 'm', 'e', '!').contentEquals("Awesome!".toCharArray()))
    }

    @Test
    fun testToCharArrayFunctionReturnsEmptyCharArrayIfGivenBlankString() {
        assertTrue(charArrayOf().contentEquals("".toCharArray()))
    }
}