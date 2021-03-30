package com.example.projet_tdm

data class User(val idUser:String, var username:String) {
    lateinit var ordersList:List<Order>
}