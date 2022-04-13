package com.robgreener.beliefspread

import java.util.UUID

/**
 * A BasicBehaviour is an implementation of Behaviour.
 *
 * @param uuid The UUID of the BasicBehaviour.
 */
public class BasicBehaviour(override var uuid: UUID) : Behaviour {
    /** Create a new BasicBehaviour with a random UUID. */
    constructor() : this(UUID.randomUUID()) {}
}
