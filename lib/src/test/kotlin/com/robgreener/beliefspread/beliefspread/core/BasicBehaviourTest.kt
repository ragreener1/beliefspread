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

package com.robgreener.beliefspread.core

import io.mockk.mockk
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class BasicBehaviourTest {
    @Test
    fun `constructor assigns uuid`() {
        val uuid = UUID.randomUUID()
        val behaviour = BasicBehaviour("b", uuid)
        assertEquals(uuid, behaviour.uuid)
    }

    @Test
    fun `constructor assigns random uuid`() {
        val b1 = BasicBehaviour("b")
        val b2 = BasicBehaviour("b")
        assertNotEquals(b1.uuid, b2.uuid)
    }

    @Test
    fun `constructor assigns name`() {
        val b = BasicBehaviour("b")
        assertEquals("b", b.name)
    }

    @Test
    fun `full constructor assigns name`() {
        val b = BasicBehaviour("b", UUID.randomUUID())
        assertEquals("b", b.name)
    }

    @Test
    fun `equals when UUID equal`() {
        val uuid = UUID.randomUUID()
        val b1 = BasicBehaviour("b1", uuid)
        val b2 = BasicBehaviour("b2", uuid)

        assertEquals(b1, b2)
    }

    @Test
    fun `equals when same object`() {
        val b = BasicBehaviour("b")
        assertEquals(b, b)
    }

    @Test
    fun `equals when different class`() {
        val b1 = BasicBehaviour("b")
        val s = mockk<Behaviour>()
        assertNotEquals<Any>(s, b1)
    }

    @Test
    fun `equals when null`() {
        val b1 = BasicBehaviour("b")
        val b2: BasicBehaviour? = null
        assertNotEquals(b1, b2)
    }

    @Test
    fun `equals when not equal`() {
        val b1 = BasicBehaviour("b1")
        val b2 = BasicBehaviour("b2")
        assertNotEquals(b1, b2)
    }

    @Test
    fun `test hashCode`() {
        val uuid = UUID.randomUUID()
        val b = BasicBehaviour("b", uuid)
        assertEquals(uuid.hashCode(), b.hashCode())
    }
}
