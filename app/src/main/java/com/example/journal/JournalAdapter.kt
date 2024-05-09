package com.example.journal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JournalAdapter(private val onItemClick: (JournalEntry) -> Unit) : RecyclerView.Adapter<JournalAdapter.ViewHolder>() {

    private var entries = emptyList<JournalEntry>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.journal_entry, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = entries[position]
        holder.dateTextView.text = entry.date
        holder.titleTextView.text = entry.title
        holder.contentTextView.text = entry.content

        // Set click listener
        holder.itemView.setOnClickListener { onItemClick(entry) }
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    fun setEntries(entries: List<JournalEntry>) {
        this.entries = entries
        notifyDataSetChanged()
    }
}
