package com.ahmad.aghazadeh.noteita.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahmad.aghazadeh.noteita.framwork.room.DateConverter
import com.ahmad.aghazadeh.noteita.framwork.room.UUIDConverter
import com.ahmad.aghazadeh.noteita.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}