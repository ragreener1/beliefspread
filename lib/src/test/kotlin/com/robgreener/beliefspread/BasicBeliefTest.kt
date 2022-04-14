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

package com.robgreener.beliefspread

import io.mockk.mockk
import org.apache.commons.lang3.reflect.FieldUtils
import java.util.*
import kotlin.test.*

class BasicBeliefTest {
    @Test
    fun constructorAssignsUUID() {
        val uuid = UUID.randomUUID()
        val belief = BasicBelief("b", uuid)
        assertEquals(uuid, belief.uuid)
    }

    @Test
    fun constructorGeneratesRandomUUID() {
        val b1 = BasicBelief("b")
        val b2 = BasicBelief("b")
        assertNotEquals(b1.uuid, b2.uuid)
    }

    @Test
    fun constructorAssignsName() {
        val b = BasicBelief("b")
        assertEquals("b", b.name)
    }

    @Test
    fun fullConstructorAssignsName() {
        val b = BasicBelief("b", UUID.randomUUID())
        assertEquals("b", b.name)
    }

    @Test
    fun getPerceptionWhenExists() {
        val belief = BasicBelief("belief")
        val behaviour = mockk<Behaviour>()
        val perception = HashMap<Behaviour, Double>()
        perception[behaviour] = 0.5
        FieldUtils.writeField(belief, "perception", perception, true)

        assertEquals(0.5, belief.getPerception(behaviour))
    }

    @Test
    fun getPerceptionWhenNotExists() {
        val belief = BasicBelief("belief")
        val behaviour = mockk<Behaviour>()
        val perception = HashMap<Behaviour, Double>()
        FieldUtils.writeField(belief, "perception", perception, true)

        assertEquals(null, belief.getPerception(behaviour))
    }

    @Test
    fun setPerceptionDeleteWhenExists() {
        val belief = BasicBelief("belief")
        val behaviour = mockk<Behaviour>()
        val perception = HashMap<Behaviour, Double>()
        perception[behaviour] = 0.5
        FieldUtils.writeField(belief, "perception", perception, true)

        belief.setPerception(behaviour, null)
        assertEquals(null, perception[behaviour])
    }

    @Test
    fun setPerceptionDeleteWhenNotExists() {
        val belief = BasicBelief("belief")
        val behaviour = mockk<Behaviour>()
        val perception = HashMap<Behaviour, Double>()
        FieldUtils.writeField(belief, "perception", perception, true)

        belief.setPerception(behaviour, null)
        assertEquals(null, perception[behaviour])
    }

    @Test
    fun setPerceptionWhenTooHigh() {
        val belief = BasicBelief("belief")
        val behaviour = mockk<Behaviour>()
        val perception = HashMap<Behaviour, Double>()
        FieldUtils.writeField(belief, "perception", perception, true)

        val e = assertFailsWith<IllegalArgumentException> { belief.setPerception(behaviour, 2.0) }
        assertEquals(e.message, "perception is greater than 1")
    }

    @Test
    fun setPerceptionWhenTooLow() {
        val belief = BasicBelief("belief")
        val behaviour = mockk<Behaviour>()
        val perception = HashMap<Behaviour, Double>()
        FieldUtils.writeField(belief, "perception", perception, true)

        val e = assertFailsWith<IllegalArgumentException> { belief.setPerception(behaviour, -2.0) }
        assertEquals(e.message, "perception is less than -1")
    }

    @Test
    fun setPerceptionWhenExists() {
        val belief = BasicBelief("belief")
        val behaviour = mockk<Behaviour>()
        val perception = HashMap<Behaviour, Double>()
        perception[behaviour] = 0.5
        FieldUtils.writeField(belief, "perception", perception, true)

        belief.setPerception(behaviour, 0.2)
        assertEquals(0.2, perception[behaviour])
    }

    @Test
    fun setPerceptionWhenNotExists() {
        val belief = BasicBelief("belief")
        val behaviour = mockk<Behaviour>()
        val perception = HashMap<Behaviour, Double>()
        FieldUtils.writeField(belief, "perception", perception, true)

        belief.setPerception(behaviour, 0.2)
        assertEquals(0.2, perception[behaviour])
    }

    @Test
    fun relationshipIsEmptyOnInitialization() {
        val belief = BasicBelief("belief")
        assertTrue(
            (FieldUtils.readField(belief, "relationship", true) as MutableMap<*, *>)
                .isEmpty()
        )
    }

    @Test
    fun getRelationshipWhenExists() {
        val b1 = BasicBelief("belief")
        val b2 = mockk<Belief>()
        val relationship = HashMap<Belief, Double>()
        relationship[b2] = 0.2
        FieldUtils.writeField(b1, "relationship", relationship, true)
        assertEquals(0.2, b1.getRelationship(b2))
    }

    @Test
    fun getRelationshipWhenNotExists() {
        val b1 = BasicBelief("belief")
        val b2 = mockk<Belief>()
        val relationship = HashMap<Belief, Double>()
        FieldUtils.writeField(b1, "relationship", relationship, true)
        assertEquals(null, b1.getRelationship(b2))
    }

    @Test
    fun setRelationshipDeleteWhenExists() {
        val b1 = BasicBelief("belief")
        val b2 = mockk<Belief>()
        val relationship = HashMap<Belief, Double>()
        relationship[b2] = 0.2
        FieldUtils.writeField(b1, "relationship", relationship, true)
        b1.setRelationship(b2, null)
        assertEquals(null, relationship[b2])
    }

    @Test
    fun setRelationshipDeleteWhenNotExists() {
        val b1 = BasicBelief("belief")
        val b2 = mockk<Belief>()
        val relationship = HashMap<Belief, Double>()
        FieldUtils.writeField(b1, "relationship", relationship, true)
        b1.setRelationship(b2, null)
        assertEquals(null, relationship[b2])
    }

    @Test
    fun setRelationshipWhenTooHigh() {
        val b1 = BasicBelief("belief")
        val b2 = mockk<Belief>()
        val relationship = HashMap<Belief, Double>()
        FieldUtils.writeField(b1, "relationship", relationship, true)
        val e = assertFailsWith<IllegalArgumentException> { b1.setRelationship(b2, 2.0) }
        assertEquals("relationship is greater than 1", e.message)
    }

    @Test
    fun setRelationshipWhenTooLow() {
        val b1 = BasicBelief("belief")
        val b2 = mockk<Belief>()
        val relationship = HashMap<Belief, Double>()
        FieldUtils.writeField(b1, "relationship", relationship, true)
        val e = assertFailsWith<IllegalArgumentException> { b1.setRelationship(b2, -2.0) }
        assertEquals("relationship is less than -1", e.message)
    }

    @Test
    fun setRelationshipWhenExists() {
        val b1 = BasicBelief("belief")
        val b2 = mockk<Belief>()
        val relationship = HashMap<Belief, Double>()
        relationship[b2] = 0.2
        FieldUtils.writeField(b1, "relationship", relationship, true)
        b1.setRelationship(b2, 0.5)
        assertEquals(0.5, relationship[b2])
    }

    @Test
    fun setRelationshipWhenNotExists() {
        val b1 = BasicBelief("belief")
        val b2 = mockk<Belief>()
        val relationship = HashMap<Belief, Double>()
        FieldUtils.writeField(b1, "relationship", relationship, true)
        b1.setRelationship(b2, -0.5)
        assertEquals(-0.5, relationship[b2])
    }
}