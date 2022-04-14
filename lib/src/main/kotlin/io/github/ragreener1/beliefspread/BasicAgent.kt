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

import java.util.*

/**
 * A [BasicAgent] is an implementation of [Agent].
 *
 * @property uuid The [UUID] of the [BasicAgent].
 * @constructor Create a new [BasicAgent] with a supplied [UUID].
 * @author Robert Greener
 * @since v0.1.0
 */
class BasicAgent(override var uuid: UUID) : Agent {
    /**
     * Create a new [BasicAgent] with a random [UUID].
     *
     * The [UUID] is generated using [UUID.randomUUID].
     *
     * @author Robert Greener
     * @since v0.1.0
     */
    constructor() : this(UUID.randomUUID())
}