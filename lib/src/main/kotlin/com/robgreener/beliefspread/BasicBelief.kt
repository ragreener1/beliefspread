package com.robgreener.beliefspread

import java.util.*

/**
 * A BasicBelief is an implementation of Belief.
 *
 * @param name The name of the Belief.
 * @param uuid The UUID of the Belief
 */
class BasicBelief(override var name: String, override var uuid: UUID) : Belief {
    private val perception: MutableMap<Behaviour, Double> = HashMap()

    /**
     * Create a new BasicBelief with a random UUID.
     *
     * @param name The name of the BasicBelief.
     */
    constructor(name: String) : this(name, UUID.randomUUID())

    override fun getPerception(behaviour: Behaviour): Double? {
        return perception[behaviour]
    }

    override fun setPerception(behaviour: Behaviour, perception: Double?) {
        if (perception == null) {
            this.perception.remove(behaviour)
        } else if (perception > 1.0) {
            throw IllegalArgumentException("perception is greater than 1")
        } else if (perception < -1.0) {
            throw IllegalArgumentException("perception is less than -1")
        } else {
            this.perception[behaviour] = perception
        }
    }
}