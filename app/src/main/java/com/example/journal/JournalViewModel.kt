package com.example.journal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JournalViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: JournalRepository
    val allEntries: LiveData<List<JournalEntry>>

    init {
        val journalDao = JournalDatabase.getDatabase(application).journalDao()
        repository = JournalRepository(journalDao)
        allEntries = repository.allEntries
    }

    fun insert(entry: JournalEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(entry)
        }
    }

    fun delete(entry: JournalEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(entry)
        }
    }
}
