package com.example.journal



import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface JournalEntryDao {
    @Query("SELECT * FROM journal_entries ORDER BY date DESC")
    fun getAllEntries(): LiveData<List<JournalEntry>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entry: JournalEntry)

    @Update
    fun update(entry: JournalEntry)

    @Delete
    fun delete(entry: JournalEntry)

}


