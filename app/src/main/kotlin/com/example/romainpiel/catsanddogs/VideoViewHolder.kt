package com.example.romainpiel.catsanddogs

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView

    init {
        titleTextView = itemView.findViewById(R.id.title) as TextView
    }

    fun bind(item: Video) {
        titleTextView.text = item.title
    }

}

