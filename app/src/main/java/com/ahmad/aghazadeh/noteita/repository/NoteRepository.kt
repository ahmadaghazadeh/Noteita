package com.ahmad.aghazadeh.noteita.repository

import com.ahmad.aghazadeh.noteita.data.NoteDao
import com.ahmad.aghazadeh.noteita.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {


    fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getNotes()
    }

    suspend fun getNoteById(id: String): Note{
        return noteDao.getNoteById(id)
    }

    suspend fun insertNote(note: Note){

        noteDao.insertNote(note)
    }

    suspend fun deleteAllNotes(){
        noteDao.deleteAllNotes()
    }


    suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note)
    }

    suspend fun updateNote(note: Note){
        noteDao.update(note)
    }


}