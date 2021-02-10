package com.example.tp5

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie( var title:String, var year: String, var language:String){
    @PrimaryKey(autoGenerate = true) var id: Long=0
}