package com.example.tp7_v2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitService {
    val endpoint: Endpoint by lazy {
        Retrofit.Builder().baseUrl("http://8e5bcd78c58a.ngrok.io").addConverterFactory(GsonConverterFactory.create()).build().create(Endpoint::class.java)
    }
}