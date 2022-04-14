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

package com.robgreener.beliefspread

import java.util.*

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
    constructor(name: String) : this(name, UUID.randomUUID())
}
