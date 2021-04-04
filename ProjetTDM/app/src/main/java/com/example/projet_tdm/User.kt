package com.example.projet_tdm

data class User(val id:String, var username:String) {
    lateinit var ordersList:List<Order>
}