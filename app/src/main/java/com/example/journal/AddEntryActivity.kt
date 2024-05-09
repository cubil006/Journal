package com.example.journal


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
//import kotlinx.android.synthetic.main.activity_add_entry.*

class AddEntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_entry)

        // Handle save button click
        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            saveJournalEntry()
        }
    }

    private fun saveJournalEntry() {
        val dateEditText = findViewById<EditText>(R.id.dateEditText)
        val contentEditText = findViewById<EditText>(R.id.contentEditText)
        val extraEditText = findViewById<EditText>(R.id.extraEditText)

        val date = dateEditText.text.toString()
        val content = contentEditText.text.toString()
        val extra = extraEditText.text.toString()

        // Validate input fields (optional)

        // Create a new JournalEntry object
        val entry = JournalEntry(date = date, title = content, content = extra)

        // Call insert() function of JournalViewModel to save the entry
        val viewModel = ViewModelProvider(this).get(JournalViewModel::class.java)
        viewModel.insert(entry)

        // Finish the activity
        finish()
    }
}
