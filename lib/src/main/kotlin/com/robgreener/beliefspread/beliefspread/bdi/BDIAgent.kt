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

package com.robgreener.beliefspread.bdi

import com.robgreener.beliefspread.core.Agent
import com.robgreener.beliefspread.core.Belief
import com.robgreener.beliefspread.core.UnstableAPI

/**
 * This is an [Agent] that makes decision using the BDI model.
 *
 * @author Robert Greener
 * @since v0.13.0
 */
@UnstableAPI
interface BDIAgent : Agent {
    /**
     * Chooses an action to perform at a given time.
     *
     * This updates the action using [Agent.setAction].
     *
     * An action is any [com.robgreener.beliefspread.core.Behaviour]
     *
     * @param time The time.
     * @param beliefs The [Belief]s.
     * @author Robert Greener
     * @since v0.13.0
     */
    @UnstableAPI
    fun chooseAction(time: UInt, beliefs: Collection<Belief>)
}