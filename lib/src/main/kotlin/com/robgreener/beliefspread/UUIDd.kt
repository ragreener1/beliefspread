package com.robgreener.beliefspread

import java.util.UUID

/** Something with a UUID. */
public interface UUIDd {
    /** Gets the UUID of the Object. */
    fun getUuid(): UUID

    /**
     * Sets the UUID of the object.
     *
     * @param uuid The new UUID.
     */
    fun setUuid(uuid: UUID)
}
