package com.example.tp5_v2

import com.example.projet_tdm.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val userService: UserService by lazy {
        Retrofit.Builder().baseUrl("http://79c681f46288.ngrok.io").addConverterFactory(GsonConverterFactory.create()).build().create(UserService::class.java)
    }
}