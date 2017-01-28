package com.example.romainpiel.catsanddogs

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.recycler_view_main) as? RecyclerView
        recyclerView?.adapter = VideoAdapter()
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

}
