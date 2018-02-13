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

/**
 * Tests for functions in StringsExtended.kt
 */
@Suppress("unused")
class StringsExtendedTest {
    /**
     * Tests for CharSequence?.isNotNullOrBlank()
     */
    class IsNotNullOrBlankExtensionFunctionForNullableCharSequenceTest {
        @Test
        fun testThisHavingACharacterReturnsTrue() = assertTrue("A".isNotNullOrBlank())

        @Test
        fun testThisHavingCharactersReturnsTrue() = assertTrue(" AB C ".isNotNullOrBlank())

        @Test
        fun testThisBeingNullReturnsFalse() = assertFalse(null.isNotNullOrBlank())

        @Test
        fun testThisBeingEmptyReturnsFalse() = assertFalse("".isNotNullOrBlank())

        @Test
        fun testThisOnlyHavingAWhitespaceReturnsFalse() = assertFalse(" ".isNotNullOrBlank())

        @Test
        fun testThisOnlyHavingWhitespacesReturnsFalse() = assertFalse("   ".isNotNullOrBlank())
    }

    /**
     * Tests for CharSequence?.isNotNullOrEmpty()
     */
    class IsNotNullOrEmptyExtensionFunctionForNullableCharSequenceTest {
        @Test
        fun testThisHavingACharacterReturnsTrue() = assertTrue("A".isNotNullOrEmpty())

        @Test
        fun testThisHavingCharactersReturnsTrue() = assertTrue(" AB C ".isNotNullOrEmpty())

        @Test
        fun testThisBeingNullReturnsFalse() = assertFalse(null.isNotNullOrEmpty())

        @Test
        fun testThisBeingEmptyReturnsFalse() = assertFalse("".isNotNullOrEmpty())

        @Test
        fun testThisOnlyHavingAWhitespaceReturnsTrue() = assertTrue(" ".isNotNullOrEmpty())

        @Test
        fun testThisOnlyHavingWhitespacesReturnsTrue() = assertTrue("   ".isNotNullOrEmpty())
    }

    /**
     * Test for CharSequence?.toStringBuilder()
     */
    class ToStringBuilderExtensionFunctionForCharSequenceTest {
        @Test
        fun testThisReturnsStringBuilderWithValueOfThis() {
            assertEquals(expected = "Team, unite up!", actual = "Team, unite up!".toStringBuilder().toString())
        }
    }

    /**
     * Tests for Iterable<CharSequence>.trimAll()
     */
    class TrimAllExtensionFunctionForIterableOfCharSequenceTest {
        @Test
        fun testThisReturnsListOfTrimmedValues() {
            val testData: List<String> =
                    listOf(" a ", "b", " cde", "fgh ", "ijk", " lmn ", "o p", " q r", "s t ", " u v ")
            val expectedResult: List<String> = listOf("a", "b", "cde", "fgh", "ijk", "lmn", "o p", "q r", "s t", "u v")
            assertEquals(expected = expectedResult, actual = testData.trimAll())
        }

        @Test
        fun testThisBeingEmptyReturnsEmptyList() {
            assertEquals(expected = listOf<String>(), actual = setOf<String>().trimAll())
        }

        @Test
        fun testThisReturnsNewListInstance() {
            assertNotSame(illegal = listOf("a", "b", "c"), actual = listOf("a", "b", "c").trimAll())
        }

    }

    /**
     * Tests for String.concat(String)
     */
    class ConcatExtensionFunctionForStringTest {

        @Test
        fun testThisConcatenatesValueOfThisAndAnother() {
            assertEquals(expected = "You're not Alexander!", actual = "You're not".concat(" Alexander!"))
        }

        @Test
        fun testThisWithBlankValueConcatenatesValueOfThisAndAnotherBlank() {
            assertEquals(expected = "", actual = "".concat(""))
        }

        @Test
        fun testThisWithWhitespaceValueConcatenatesValueOfThisAndAnotherWhitespace() {
            assertEquals(expected = "   ", actual = " ".concat("  "))
        }

    }

    /**
     *  Tests for String.toBoolean()
     */
    class ToBooleanExtensionFunctionForStringTest {
        @Test
        fun testThisContainingTrueLowercaseReturnsTrue() = assertTrue("true".toBoolean())

        @Test
        fun testThisContainingTrueUppercaseReturnsTrue() = assertTrue("TRUE".toBoolean())

        @Test
        fun testThisContainingTrueMixedCaseReturnsTrue() = assertTrue("TrUe".toBoolean())

        @Test
        fun testThisSurroundedWithWhitespaceReturnsFalse() = assertFalse(" true  ".toBoolean())

        @Test
        fun testThisContainingFalseReturnsFalse() = assertFalse("false".toBoolean())

        @Test
        fun testThisContainingNonBooleanValueReturnsFalse() = assertFalse("yes".toBoolean())
    }

    /**
     * Tests for String.toCharArray()
     */
    class ToCharArrayExtensionFunctionForStringTest {
        @Test
        fun testThisReturnsCharArrayContainingValueOfThis() {
            assertTrue(charArrayOf('A', 'w', 'e', 's', 'o', 'm', 'e', '!').contentEquals("Awesome!".toCharArray()))
        }

        @Test
        fun testThisWithBlankValueReturnsEmptyCharArray() = assertTrue(charArrayOf().contentEquals("".toCharArray()))
    }
}