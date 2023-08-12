package com.ahmad.aghazadeh.noteita.componets

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NoteButton(
    modifier: Modifier =Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
){
    Button(
        modifier = modifier,
        shape=CircleShape,
        onClick = onClick,
        enabled = enabled,
        content = {
            Text(text = text)})
}