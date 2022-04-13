package com.robgreener.beliefspread

import io.mockk.mockk
import org.apache.commons.lang3.reflect.FieldUtils
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

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
}