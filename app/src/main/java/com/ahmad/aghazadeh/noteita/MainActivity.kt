package com.ahmad.aghazadeh.noteita

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahmad.aghazadeh.noteita.data.NotesDataSource
import com.ahmad.aghazadeh.noteita.model.Note
import com.ahmad.aghazadeh.noteita.screens.NotesScreen
import com.ahmad.aghazadeh.noteita.ui.theme.NoteitaTheme

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
                    val notes = remember{
                        mutableStateListOf<Note>()
                    }
                    NotesScreen(notes=notes, onAddNote = {
                        notes.add(it)
                        Toast.makeText(this,"Note added", Toast.LENGTH_SHORT).show()
                    }, onRemoveNote = {
                        notes.remove(it)
                        Toast.makeText(this,"Note removed", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteitaTheme {
    }
}