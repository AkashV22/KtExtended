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
import kotlin.test.assertNotNull

class PropertiesExtendedTest {
    @Test
    fun testToNotNullPropResolvesNonNullableVariablesCorrectly() {
        val someProperties = SomeProperties(propA = "A", propB = "B")
        assertEquals(expected = "A", actual = toNonNullProp("propA", someProperties::propA))
        assertEquals(expected = "B", actual = toNonNullProp("propB", someProperties::propB))
        assertNotNull(actual = toNonNullProp("propA", someProperties::propA))
        assertNotNull(actual = toNonNullProp("propB", someProperties::propB))
    }

    private data class SomeProperties(var propA: String?, var propB: String)
}