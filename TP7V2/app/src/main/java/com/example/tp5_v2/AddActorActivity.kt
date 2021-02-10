package com.example.tp7_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_actor)
        findViewById<Button>(R.id.submitButton).setOnClickListener { view ->
            var firstNameInput=findViewById<EditText>(R.id.actorFirstNameInput) as EditText;
            var lastNameInput=findViewById<EditText>(R.id.actorLastNameInput) as EditText;
            var genderInput=findViewById<EditText>(R.id.actorGenderInput) as EditText;
            val firstname= firstNameInput.text.toString()
            val lastname= lastNameInput.text.toString()
            val gender= genderInput.text.toString()
            val actor= Actor(firstname,lastname,gender)
            val call = RetrofitService.endpoint.addActor(actor)
            call.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Toast.makeText(getApplicationContext(),"add sucess", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(getApplicationContext(),t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}