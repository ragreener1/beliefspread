package com.robgreener.beliefspread

import java.util.*

/**
 * A BasicBelief is an implementation of Belief.
 *
 * @param name The name of the Belief.
 * @param uuid The UUID of the Belief
 */
class BasicBelief(override var name: String, override var uuid: UUID) : Belief {
    /**
     * Create a new BasicBelief with a random UUID.
     *
     * @param name The name of the BasicBelief.
     */
    constructor(name: String) : this(name, UUID.randomUUID())
}