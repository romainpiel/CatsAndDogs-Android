package com.example.romainpiel.catsanddogs

import com.example.romainpiel.catsanddogs.api.EventService
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class VideoRepository {
    private val eventService: EventService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://catsanddogs-kotlin-server.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        eventService = retrofit.create(EventService::class.java)
    }

    fun videos(): Single<List<Video>> {
        return eventService.getSchedule()
                .map { it.event.speakers }
                .flatMapIterable { it }
                .map { Video(it.name, it.company) }
                .toList()
    }
}