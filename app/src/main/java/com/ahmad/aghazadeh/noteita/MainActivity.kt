package com.ahmad.aghazadeh.noteita

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ahmad.aghazadeh.noteita.data.NotesDataSource
import com.ahmad.aghazadeh.noteita.model.Note
import com.ahmad.aghazadeh.noteita.screens.NoteViewModel
import com.ahmad.aghazadeh.noteita.screens.NotesScreen
import com.ahmad.aghazadeh.noteita.ui.theme.NoteitaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteitaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteViewModel =viewModel<NoteViewModel>()
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}
@Composable
fun NotesApp(noteViewModel: NoteViewModel=viewModel()){

    val notesList = noteViewModel.noteList.collectAsState().value

    NotesScreen(notes=notesList, onAddNote = {
        noteViewModel.insertNote(it)
    }, onRemoveNote = {
        noteViewModel.deleteNote(it)
    })

}

@Composable
fun GreetingPreview() {
    NoteitaTheme {
    }
}