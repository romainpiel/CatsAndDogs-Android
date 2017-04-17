package com.romainpiel.catsanddogs

import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ScheduleRepository {
    private val service: ScheduleService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://catsanddogs-kotlin-bff.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                        .build())
                .build()

        service = retrofit.create(ScheduleService::class.java)
    }

    fun schedule(from: String?): Single<List<Card>> {
        return service.getSchedule(from)
                .flatMapIterable { it }
                .toList()
    }
}