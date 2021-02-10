package com.example.tp5_v2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.displayMoviesButton).setOnClickListener { view ->
            val intent= Intent(this,DisplayMovies::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.actorsCastButton).setOnClickListener { view ->
            val intent= Intent(this,ActorsParticipatedActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.addactorButton).setOnClickListener { view ->
            val intent= Intent(this,AddActorActivity::class.java)
            startActivity(intent)
        }


    }

}