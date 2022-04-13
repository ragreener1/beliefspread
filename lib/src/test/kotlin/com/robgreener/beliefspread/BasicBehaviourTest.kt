package com.robgreener.beliefspread

import java.util.UUID
import kotlin.test.*

class BasicBehaviourTest {
    @Test
    fun constructorAssignsUUID() {
        val uuid = UUID.randomUUID()
        val behaviour = BasicBehaviour(uuid)
        assertEquals(uuid, behaviour.uuid)
    }

    @Test
    fun constructorGeneratesRandomUUID() {
        val b1 = BasicBehaviour()
        val b2 = BasicBehaviour()
        assertNotEquals(b1.uuid, b2.uuid)
    }
}
