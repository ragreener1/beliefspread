/*
 * belief-spread
 * Copyright (c) 2022 Robert Greener
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the LICENSE, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public LICENSE
 * along with this program. If not, see <https://www.gnu.org/licenses>
 */

package io.github.ragreener1.beliefspread

import io.mockk.mockk
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class BasicAgentTest {
    @Test
    fun `constructor assigns uuid`() {
        val uuid = UUID.randomUUID()
        val a = BasicAgent(uuid)
        assertEquals(uuid, a.uuid)
    }

    @Test
    fun `constructor assigns random uuid`() {
        val a1 = BasicAgent()
        val a2 = BasicAgent()
        assertNotEquals(a1.uuid, a2.uuid)
    }

    @Test
    fun `equals when uuids equal`() {
        val uuid = UUID.randomUUID()
        val a1 = BasicAgent(uuid)
        val a2 = BasicAgent(uuid)

        assertEquals(a1, a2)
    }

    @Test
    fun `equals when same object`() {
        val a1 = BasicAgent()
        assertEquals(a1, a1)
    }

    @Test
    fun `equals when different class`() {
        val a1 = BasicAgent()
        val s = mockk<Belief>()
        assertNotEquals<Any>(s, a1)
    }

    @Test
    fun `equals when null`() {
        val a1 = BasicAgent()
        val a2: BasicAgent? = null
        assertNotEquals(a1, a2)
    }

    @Test
    fun `equals when uuids not equal`() {
        val a1 = BasicAgent()
        val a2 = BasicAgent()
        assertNotEquals(a1, a2)
    }

    @Test
    fun `test hashCode`() {
        val uuid = UUID.randomUUID()
        val a = BasicAgent(uuid)
        assertEquals(uuid.hashCode(), a.hashCode())
    }
}