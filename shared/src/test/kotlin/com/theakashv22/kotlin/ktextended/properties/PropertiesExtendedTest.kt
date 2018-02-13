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

package com.theakashv22.kotlin.ktextended.properties

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Tests for function in PropertiesExtended.kt
 */
@Suppress("unused")
class PropertiesExtendedTest {
    /**
     * Tests for toNonNullProp(String, () -> T?)
     */
    class ToNonNullPropFunctionTest {
        @Test
        fun testGettingNullablePropReturnsNonNullValue() {
            assertEquals(
                    expected = "A",
                    actual = toNonNullProp("propA", getSomePropertiesWithValuesAAndB()::propA)
            )
        }

        @Test
        fun testGettingNonNullPropReturnsNonNullValue() {
            assertEquals(
                    expected = "B",
                    actual = toNonNullProp("propB", getSomePropertiesWithValuesAAndB()::propB)
            )
        }

        @Test
        fun testChangingPropValueToNullAfterNullCheckResultsInIllegalArgumentException() {
            val someProperties: SomeProperties = getSomePropertiesWithValuesAAndB()

            var t: Throwable? = null
            try {
                someProperties.propA = null
                toNonNullProp("propA", someProperties::propA)
            } catch (e: IllegalArgumentException) {
                t = e
            }

            assertEquals(expected = IllegalArgumentException::class, actual = if (t != null) t::class else null)
        }

        private fun getSomePropertiesWithValuesAAndB(): SomeProperties = SomeProperties(propA = "A", propB = "B")

        private data class SomeProperties(var propA: String?, var propB: String)
    }
}