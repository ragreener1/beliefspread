package com.robgreener.beliefspread

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
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
}