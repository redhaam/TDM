package com.example.tp7_v2

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Endpoint {
    @GET("getmovies")
    fun getMovies(): Call<List<Movie>>

    @GET("getmovieactors/{movietitle}")
    fun getActorsParticipated(@Path("movietitle") titleMovie:String):Call<List<Actor>>


    @POST("addactor")
    fun addActor(@Body actor:Actor):Call<String>

}