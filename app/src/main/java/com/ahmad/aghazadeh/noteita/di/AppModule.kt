package com.ahmad.aghazadeh.noteita.di

import android.content.Context
import androidx.room.Room
import com.ahmad.aghazadeh.noteita.data.NoteDao
import com.ahmad.aghazadeh.noteita.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao=noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase
    = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
         "notes_db"
    )
        .fallbackToDestructiveMigration()
        .build()

}