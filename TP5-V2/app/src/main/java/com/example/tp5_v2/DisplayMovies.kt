package com.example.tp5_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayMovies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_movies)
        val call = RetrofitService.endpoint.getMovies()
        call.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                Toast.makeText(getApplicationContext(),response.body().toString(), Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(getApplicationContext(),t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}