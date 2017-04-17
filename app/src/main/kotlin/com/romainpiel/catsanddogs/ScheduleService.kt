package com.romainpiel.catsanddogs

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ScheduleService {
    @GET("/schedule.json")
    fun getSchedule(@Query("from") from: String?): Observable<List<Card>>
}