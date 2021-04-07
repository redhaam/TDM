package com.example.projet_tdm

import com.example.projet_tdm.OrderService
import com.example.projet_tdm.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val userService: UserService by lazy {
        Retrofit.Builder().baseUrl("http://4b0bf6ec7a96.ngrok.io").addConverterFactory(GsonConverterFactory.create()).build().create(UserService::class.java)
    };
    val orderService: OrderService by lazy {
        Retrofit.Builder().baseUrl("http://4b0bf6ec7a96.ngrok.io").addConverterFactory(GsonConverterFactory.create()).build().create(OrderService::class.java)
    }
}