package com.example.tp5

import android.app.Application

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        RoomService.context=applicationContext;
    }
}