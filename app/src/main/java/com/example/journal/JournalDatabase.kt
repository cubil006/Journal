package com.example.journal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [JournalEntry::class], version = 1, exportSchema = false)

abstract class JournalDatabase : RoomDatabase() {
    abstract fun journalDao(): JournalEntryDao

    companion object {
        @Volatile
        private var INSTANCE: JournalDatabase? = null

        fun getDatabase(context: Context): JournalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JournalDatabase::class.java,
                    "journal_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
