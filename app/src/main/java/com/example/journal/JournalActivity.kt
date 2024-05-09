package com.example.journal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JournalActivity : AppCompatActivity() {

    private lateinit var viewModel: JournalViewModel
    private lateinit var adapter: JournalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)

        viewModel = ViewModelProvider(this).get(JournalViewModel::class.java)
        adapter = JournalAdapter { entry ->
            viewModel.delete(entry)
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.allEntries.observe(this, Observer { entries ->
            entries?.let { adapter.setEntries(it) }
        })

        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            startActivity(Intent(this, AddEntryActivity::class.java))
        }
    }
}
