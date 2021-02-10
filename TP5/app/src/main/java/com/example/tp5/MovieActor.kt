package com.example.tp5

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "movie_actor", primaryKeys = arrayOf("idActor","idMovie"),
    foreignKeys = arrayOf(ForeignKey(entity = Actor::class, parentColumns = arrayOf("id") ,childColumns = arrayOf("idActor")),ForeignKey(entity = Movie::class, parentColumns = arrayOf("id") ,childColumns = arrayOf("idMovie")))
)
data class MovieActor(
    var idActor:Long, var idMovie:String
)