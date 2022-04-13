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
    private val relationship: MutableMap<Belief, Double> = HashMap()

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

    override fun getRelationship(belief: Belief): Double? {
        return relationship[belief]
    }

    override fun setRelationship(belief: Belief, relationship: Double?) {
        if (relationship == null) {
            this.relationship.remove(belief)
        } else if (relationship > 1.0) {
            throw IllegalArgumentException("relationship is greater than 1")
        } else if (relationship < -1.0) {
            throw IllegalArgumentException("relationship is less than -1")
        } else {
            this.relationship[belief] = relationship
        }
    }
}