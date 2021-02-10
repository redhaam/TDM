package com.example.tp5

import android.content.Context
import androidx.room.Room

object RoomService {
    lateinit var context:Context

    val appDatabase by lazy {
        Room.databaseBuilder(context,AppDatabase::class.java,"tp5")
            .allowMainThreadQueries().build()
    }
}