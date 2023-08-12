package com.ahmad.aghazadeh.noteita.model

import java.time.LocalDateTime
import java.util.UUID

data class Note (
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now(),
)



