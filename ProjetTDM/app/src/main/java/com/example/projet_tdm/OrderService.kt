package com.example.projet_tdm

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface OrderService {

    @GET("orders") fun getOrders(@Header("Authorization") authToken:String):Call<List<Order>>
}