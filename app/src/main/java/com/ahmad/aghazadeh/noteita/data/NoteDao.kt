package com.ahmad.aghazadeh.noteita.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ahmad.aghazadeh.noteita.model.Note
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface NoteDao {
    @Query("SELECT * from note_table")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * from note_table WHERE id = :id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteAllNotes()

    @Query("DELETE FROM note_table WHERE id = :id")
    suspend fun deleteNoteById(id: String)

    @Update(onConflict =OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)


}
