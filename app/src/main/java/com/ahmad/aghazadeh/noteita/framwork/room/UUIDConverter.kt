package com.ahmad.aghazadeh.noteita.framwork.room

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {

    @TypeConverter
    fun fromUUID(uuid: String?): String? {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFormString(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }
}