package com.example.journal

import androidx.lifecycle.LiveData

class JournalRepository(private val journalDao: JournalEntryDao) {
    val allEntries: LiveData<List<JournalEntry>> = journalDao.getAllEntries()

     fun insert(entry: JournalEntry) {
        journalDao.insert(entry)
    }


     fun delete(entry: JournalEntry) {
        journalDao.delete(entry)
    }
}
