package com.example.tp5

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="actors")
data class Actor( var firstName:String, var lastName:String, var gender:String){
    @PrimaryKey(autoGenerate = true) var id:Long=0
}