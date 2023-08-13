package com.ahmad.aghazadeh.noteita.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.ahmad.aghazadeh.noteita.data.NotesDataSource
import com.ahmad.aghazadeh.noteita.model.Note

 class NoteViewModel : ViewModel() {
    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }
    fun getAllNotes(): List<Note>{
        return noteList
    }
}