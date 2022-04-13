package com.robgreener.beliefspread

import java.util.UUID

/**
 * A BasicBehaviour is an implementation of Behaviour.
 *
 * @param name The name of the BasicBehaviour.
 * @param uuid The UUID of the BasicBehaviour.
 */
class BasicBehaviour(override var name: String, override var uuid: UUID) : Behaviour {
    /**
     * Create a new BasicBehaviour with a random UUID.
     *
     * @param name The name of the BasicBehaviour.
     */
    constructor(name: String) : this(name, UUID.randomUUID()) {}
}
