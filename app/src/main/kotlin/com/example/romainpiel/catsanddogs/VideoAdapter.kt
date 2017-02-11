package com.example.romainpiel.catsanddogs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class VideoAdapter : RecyclerView.Adapter<VideoViewHolder>() {
    var items = emptyList<Video>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder?, position: Int) {
        val item = items[position]
        holder?.bind(item)
    }

    override fun getItemCount() = items.size
}
