package com.example.tp7_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActorsParticipatedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actors_participated)
        findViewById<Button>(R.id.search).setOnClickListener { view ->
            var titleInput=findViewById<EditText>(R.id.titleInput) as EditText;
            val title= titleInput.text.toString()
            val call = RetrofitService.endpoint.getActorsParticipated(title)
            call.enqueue(object : Callback<List<Actor>>{
                override fun onResponse(call: Call<List<Actor>>, response: Response<List<Actor>>) {
                    Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<List<Actor>>, t: Throwable) {
                    Toast.makeText(getApplicationContext(),t.message,Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}