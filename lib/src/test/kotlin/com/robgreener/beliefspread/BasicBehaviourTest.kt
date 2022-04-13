package com.robgreener.beliefspread

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class BasicBehaviourTest {
    @Test
    fun constructorAssignsUUID() {
        val uuid = UUID.randomUUID()
        val behaviour = BasicBehaviour("b", uuid)
        assertEquals(uuid, behaviour.uuid)
    }

    @Test
    fun constructorGeneratesRandomUUID() {
        val b1 = BasicBehaviour("b")
        val b2 = BasicBehaviour("b")
        assertNotEquals(b1.uuid, b2.uuid)
    }

    @Test
    fun constructorAssignsName() {
        val b = BasicBehaviour("b")
        assertEquals("b", b.name)
    }

    @Test
    fun fullConstructorAssignsName() {
        val b = BasicBehaviour("b", UUID.randomUUID())
        assertEquals("b", b.name)
    }
}
