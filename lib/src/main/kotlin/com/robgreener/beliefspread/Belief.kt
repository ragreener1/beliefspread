package com.robgreener.beliefspread

/**
 * A Belief.
 */
interface Belief : Named, UUIDd {
    /**
     * Gets the perception. Returns an optional double if found.
     *
     * The perception is the amount that an agent performing the behaviour can
     * be assumed to be driven by this belief.
     *
     * @param behaviour The behaviour.
     * @return The value if found.
     */
    fun getPerception(behaviour: Behaviour): Double?

    /**
     * Sets the perception
     *
     * The perception is the amount that an agent performing
     * the behaviour can be assumed to be driven by this belief.
     *
     * Deletes a perception if a null perception is supplied.
     *
     * The perception must be in the range [-1, +1]
     *
     * @param behaviour The behaviour.
     * @param perception The new perception.
     */
    @Throws(IllegalArgumentException::class)
    fun setPerception(behaviour: Behaviour, perception: Double?)
}