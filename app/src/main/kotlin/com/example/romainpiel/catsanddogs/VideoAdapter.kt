package com.example.romainpiel.catsanddogs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class VideoAdapter : RecyclerView.Adapter<VideoViewHolder>() {
    val items = listOf(Video("Ágnes Vásárhelyi"),
            Video("Michał Bendowski"),
            Video("Jorge D. Ortiz-Fuentes"),
            Video("Felix Krause"),
            Video("Scott Alexander-Bown"),
            Video("Eugenio Marletti"),
            Video("Natasha Murashev"),
            Video("Jasson Schrock"),
            Video("Ash Furrow"),
            Video("Adrian Catalan"))

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
