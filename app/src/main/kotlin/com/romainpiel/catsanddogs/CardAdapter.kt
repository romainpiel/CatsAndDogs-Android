package com.romainpiel.catsanddogs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class CardAdapter : RecyclerView.Adapter<CardViewHolder>() {
    var items = emptyList<Card>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_video, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder?, position: Int) {
        val item = items[position]
        holder?.bind(item)
    }

    override fun getItemCount() = items.size
}
