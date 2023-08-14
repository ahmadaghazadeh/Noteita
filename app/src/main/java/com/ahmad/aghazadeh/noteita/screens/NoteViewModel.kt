package com.ahmad.aghazadeh.noteita.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmad.aghazadeh.noteita.model.Note
import com.ahmad.aghazadeh.noteita.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {
    private var _noteList =MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
       viewModelScope.launch(Dispatchers.IO) {
           repository.getAllNotes().distinctUntilChanged()
               .collect{listOfNotes->
                   if(listOfNotes.isNullOrEmpty()){
                       Log.d("Empty","Empty List")
                   }else{
                       _noteList.value = listOfNotes
                   }
               }

       }
    }

    fun insertNote(note: Note)= viewModelScope.launch {
        try {
            repository.insertNote(note)
        }catch (e: Exception){
            e.toString()
        }

    }
    fun updateNote(note: Note)=viewModelScope.launch {
        try {
            repository.updateNote(note)
        }catch (e: Exception){
            e.toString()
        }

    }
    fun deleteNote(note: Note)=viewModelScope.launch {
        repository.deleteNote(note)
    }

}