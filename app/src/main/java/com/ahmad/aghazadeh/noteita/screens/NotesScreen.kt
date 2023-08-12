package com.ahmad.aghazadeh.noteita.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmad.aghazadeh.noteita.R
import com.ahmad.aghazadeh.noteita.componets.NoteButton
import com.ahmad.aghazadeh.noteita.componets.NoteInputText
import com.ahmad.aghazadeh.noteita.data.NotesDataSource
import com.ahmad.aghazadeh.noteita.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(
    notes:List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = { Text(text = stringResource(id = R.string.app_name))},
            actions ={
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = stringResource(
                    R.string.top_app_bar_notification
                )
                )

            }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor =  MaterialTheme.colorScheme.primaryContainer))
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            NoteInputText(text =title, label = "Title", onTextChange ={
                if (it.all{
                    char ->
                    char.isLetter() || char.isWhitespace()
                }){
                    title = it
                }
                  })

            NoteInputText(text = description, label = "Add a description", onTextChange ={
                if (it.all{
                            char ->
                        char.isLetter() || char.isWhitespace()
                    }){
                    description = it
                }

            } )

            NoteButton(modifier=Modifier.padding(4.dp),text = "Save", onClick = {
                onAddNote(Note(title = title, description = description))
                title = ""
                description = ""
            })
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(notes){
                    NoteRow(note = it, onNoteClick = {
                        onRemoveNote(it)
                    })
                }
            }

        }


    }
}

@Composable
fun NoteRow(note: Note, onNoteClick: (note:Note) -> Unit) {
    Card(modifier = Modifier
        .padding(4.dp)
        .clickable { onNoteClick(note) }
        .fillMaxWidth()
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp, bottomEnd = 0.dp, topStart = 0.dp))
        .padding(4.dp)) {

        Column(modifier = Modifier.padding(8.dp)
        ) {
            Text(text = note.title)
            Text(text = note.description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotesScreenPreview() {
    NotesScreen(notes= NotesDataSource().loadNotes(), onAddNote = {    }, onRemoveNote = {    })
}