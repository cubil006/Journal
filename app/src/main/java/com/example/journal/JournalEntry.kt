package com.example.journal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journal_entries")
data class JournalEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: String,
    val title: String,
    val content: String
)

