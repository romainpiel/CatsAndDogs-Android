package com.romainpiel.catsanddogs

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class CatsAndDogsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this);
    }
}