package com.ahmad.aghazadeh.noteita.data

import com.ahmad.aghazadeh.noteita.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                title = "Ahmad",
                description = "This is my first note"
            ),
            Note(
                title = "Arad",
                              description = "This is my first note"
            ),
            Note(
                title = "Shahrooz",
                description = "This is my first note"
            ),
            Note(title="Shahrooz", description = "This is my first note"),
        )
    }
}