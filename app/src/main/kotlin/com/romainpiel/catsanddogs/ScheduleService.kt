package com.romainpiel.catsanddogs

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ScheduleService {
    @GET("/kotlinconf/schedule.json")
    fun getSchedule(@Header("Accept-Language") language: String, @Query("from") from: String?): Observable<List<Item>>
}