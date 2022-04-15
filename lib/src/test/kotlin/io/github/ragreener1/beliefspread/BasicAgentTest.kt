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

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.apache.commons.lang3.reflect.FieldUtils
import java.util.*
import kotlin.test.*

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

    @Test
    fun `test activation is initialized empty`() {
        val agent = BasicAgent()
        assertTrue(
            (FieldUtils.readField(agent, "activation", true) as MutableMap<*, *>)
                .isEmpty()
        )
    }

    @Test
    fun `getActivation when exists`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val act = HashMap<UInt, MutableMap<Belief, Double>>()
        val actAt2 = HashMap<Belief, Double>()
        actAt2[b] = 0.5
        act[2u] = actAt2
        FieldUtils.writeField(a, "activation", act, true)
        assertEquals(0.5, a.getActivation(2u, b))
    }

    @Test
    fun `getActivation when time exists but belief doesn't`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val act = HashMap<UInt, MutableMap<Belief, Double>>()
        val actAt2 = HashMap<Belief, Double>()
        act[2u] = actAt2
        FieldUtils.writeField(a, "activation", act, true)
        assertEquals(null, a.getActivation(2u, b))
    }

    @Test
    fun `getActivation when not exists`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val act = HashMap<UInt, MutableMap<Belief, Double>>()
        FieldUtils.writeField(a, "activation", act, true)
        assertEquals(null, a.getActivation(2u, b))
    }

    @Test
    fun `setActivation delete when exists`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val act = HashMap<UInt, MutableMap<Belief, Double>>()
        val actAt2 = HashMap<Belief, Double>()
        actAt2[b] = 0.5
        act[2u] = actAt2
        FieldUtils.writeField(a, "activation", act, true)
        a.setActivation(2u, b, null)
        assertNull(actAt2[b])
    }

    @Test
    fun `setActivation delete when time exists but belief doesn't`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val act = HashMap<UInt, MutableMap<Belief, Double>>()
        val actAt2 = HashMap<Belief, Double>()
        act[2u] = actAt2
        FieldUtils.writeField(a, "activation", act, true)
        a.setActivation(2u, b, null)
        assertNull(actAt2[b])
    }

    @Test
    fun `setActivation delete when not exists`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val act = HashMap<UInt, MutableMap<Belief, Double>>()
        FieldUtils.writeField(a, "activation", act, true)
        a.setActivation(2u, b, null)
        assertNull(act[2u])
    }

    @Test
    fun `setActivation throws IllegalArgumentException when too high`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val e = assertFailsWith(
            IllegalArgumentException::class
        ) { a.setActivation(2u, b, 2.0); }
        assertEquals("new activation is greater than 1", e.message)
    }

    @Test
    fun `setActivation throws IllegalArgumentException when too low`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val e = assertFailsWith(
            IllegalArgumentException::class
        ) { a.setActivation(2u, b, -2.0); }
        assertEquals("new activation is less than -1", e.message)
    }

    @Test
    fun `setActivation when exists`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val act = HashMap<UInt, MutableMap<Belief, Double>>()
        val actAt2 = HashMap<Belief, Double>()
        actAt2[b] = 0.5
        act[2u] = actAt2
        FieldUtils.writeField(a, "activation", act, true)
        a.setActivation(2u, b, 0.2)
        assertEquals(0.2, actAt2[b])
    }

    @Test
    fun `setActivation when time exists but belief doesn't`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val act = HashMap<UInt, MutableMap<Belief, Double>>()
        val actAt2 = HashMap<Belief, Double>()
        act[2u] = actAt2
        FieldUtils.writeField(a, "activation", act, true)
        a.setActivation(2u, b, 0.2)
        assertEquals(0.2, actAt2[b])
    }

    @Test
    fun `setActivation when not exists`() {
        val a = BasicAgent()
        val b = mockk<Belief>()
        val act = HashMap<UInt, MutableMap<Belief, Double>>()
        FieldUtils.writeField(a, "activation", act, true)
        a.setActivation(2u, b, 0.2)
        assertEquals(0.2, act[2u]?.get(b))
    }

    @Test
    fun `weightedRelationship when exists`() {
        val a = mockk<BasicAgent>()
        val b1 = mockk<Belief>()
        val b2 = mockk<Belief>()

        every { a.getActivation(2u, b1) } returns 0.5
        every { b1.getRelationship(b2) } returns 0.1
        every { a.weightedRelationship(2u, b1, b2) } answers { callOriginal() }

        assertEquals(0.05, a.weightedRelationship(2u, b1, b2))

        verify { a.getActivation(2u, b1) }
        verify { b1.getRelationship(b2) }
    }

    @Test
    fun `weightedRelationship when activation not exists`() {
        val a = mockk<BasicAgent>()
        val b1 = mockk<Belief>()
        val b2 = mockk<Belief>()

        every { a.getActivation(2u, b1) } returns null
        every { b1.getRelationship(b2) } returns 0.1
        every { a.weightedRelationship(2u, b1, b2) } answers { callOriginal() }

        assertEquals(null, a.weightedRelationship(2u, b1, b2))

        verify { a.getActivation(2u, b1) }
        verify(exactly = 0) { b1.getRelationship(b2) }
    }

    @Test
    fun `weightedRelationship when relationship not exists`() {
        val a = mockk<BasicAgent>()
        val b1 = mockk<Belief>()
        val b2 = mockk<Belief>()

        every { a.getActivation(2u, b1) } returns 0.5
        every { b1.getRelationship(b2) } returns null
        every { a.weightedRelationship(2u, b1, b2) } answers { callOriginal() }

        assertEquals(null, a.weightedRelationship(2u, b1, b2))

        verify { a.getActivation(2u, b1) }
        verify { b1.getRelationship(b2) }
    }

    @Test
    fun `weightedRelationship when relationship and activation not exists`() {
        val a = mockk<BasicAgent>()
        val b1 = mockk<Belief>()
        val b2 = mockk<Belief>()

        every { a.getActivation(2u, b1) } returns null
        every { b1.getRelationship(b2) } returns null
        every { a.weightedRelationship(2u, b1, b2) } answers { callOriginal() }

        assertEquals(null, a.weightedRelationship(2u, b1, b2))

        verify { a.getActivation(2u, b1) }
        verify(exactly = 0) { b1.getRelationship(b2) }
    }
}