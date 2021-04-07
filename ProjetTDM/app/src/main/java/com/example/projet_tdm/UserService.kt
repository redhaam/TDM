package com.example.projet_tdm

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {

    @POST("login")
    fun login(@Body request: LoginRequest): Call<AuthResponse>

    @GET("user")
    fun getUser(@Header("Authorization") authToken:String): Call<User>
}