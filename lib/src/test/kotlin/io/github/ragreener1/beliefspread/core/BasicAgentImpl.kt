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

package io.github.ragreener1.beliefspread.core

import java.util.*

class BasicAgentImpl : BasicAgent {
    constructor() : super()
    constructor(uuid: UUID) : super(uuid)

    @Deprecated(
        "Not yet implemented", level = DeprecationLevel.ERROR,
        replaceWith = ReplaceWith("null")
    )
    override fun performAction(time: UInt, beliefs: Collection<Belief>) {
        TODO("Not yet implemented")
    }
}