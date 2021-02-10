package com.example.tp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var addButton= findViewById<Button>(R.id.addButton) as Button
        var title = findViewById<EditText>(R.id.titleInput) as EditText
        var year = findViewById<EditText>(R.id.yearInput) as EditText
        var language = findViewById<EditText>(R.id.languageInput) as EditText
        addButton.setOnClickListener { view ->
            var newMovie= Movie(title.text.toString(),year.text.toString(),language.text.toString())
            RoomService.appDatabase.getMovieDao().addMovie(newMovie);
            Toast.makeText(this,"insertion effectuée avec succès",Toast.LENGTH_SHORT).show()
        }
    }
}