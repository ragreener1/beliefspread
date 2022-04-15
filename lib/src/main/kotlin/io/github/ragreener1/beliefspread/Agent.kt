/*
 * belief-spread
 * Copyright (c) 2022 Robert Greener
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the LICENSE, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public LICENSE
 * along with this program. If not, see <https://www.gnu.org/licenses>
 */

package io.github.ragreener1.beliefspread

/**
 * An Agent which may exist in the model
 *
 * @author Robert Greener
 * @since v0.1.0
 */
interface Agent : UUIDd {
    /**
     * Get the activation (if found) of an [Agent] towards a [Belief] at a given time.
     *
     * This is always between -1 and +1.
     *
     * @param time The time.
     * @param belief The belief.
     * @return The activation (if found).
     * @author Robert Greener
     * @since v0.2.0
     */
    fun getActivation(time: UInt, belief: Belief): Double?

    /**
     * Set the activation of an [Agent] towards a [Belief] at a given time.
     *
     * If the activation is `null`, the activation is deleted.
     *
     * @param time The time.
     * @param belief The new belief.
     * @param activation The new activation.
     * @throws IllegalArgumentException If activation is not between -1 and +1 (or null).
     * @author Robert Greener
     * @since v0.2.0
     */
    @Throws(IllegalArgumentException::class)
    fun setActivation(time: UInt, belief: Belief, activation: Double?)
}