package com.romainpiel.catsanddogs

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView
    val subtitleTextView: TextView
    val dateTextView: TextView
    val timeTextView: TextView

    init {
        titleTextView = itemView.findViewById(R.id.title) as TextView
        subtitleTextView = itemView.findViewById(R.id.subtitle) as TextView
        dateTextView = itemView.findViewById(R.id.date) as TextView
        timeTextView = itemView.findViewById(R.id.time) as TextView
    }

    fun bind(item: Item) {
        titleTextView.text = item.title
        subtitleTextView.text = item.subtitle
        dateTextView.text = item.date
        timeTextView.text = item.time
    }

}

