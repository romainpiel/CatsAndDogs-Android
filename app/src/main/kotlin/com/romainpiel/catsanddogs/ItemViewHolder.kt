package com.romainpiel.catsanddogs

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.bindView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView by bindView(R.id.title)
    val subtitleTextView: TextView by bindView(R.id.subtitle)
    val dateTextView: TextView by bindView(R.id.date)
    val timeTextView: TextView by bindView(R.id.time)

    fun bind(item: Item) {
        titleTextView.text = item.title
        subtitleTextView.text = item.subtitle
        dateTextView.text = item.date
        timeTextView.text = item.time
    }

}

