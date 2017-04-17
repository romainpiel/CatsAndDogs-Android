package com.example.romainpiel.catsanddogs

import io.reactivex.Observable
import retrofit2.http.GET

interface ScheduleService {
    @GET("/schedule.json")
    fun getSchedule(): Observable<List<Card>>
}