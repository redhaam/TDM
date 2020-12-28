package com.abdennour.exo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var scoreText: TextView
    private lateinit var validerButton: Button
    private lateinit var editText: EditText
    private var score: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreText = findViewById(R.id.score)
        updateScore()
        editText = findViewById(R.id.entrer_text)
        validerButton = findViewById(R.id.valider)
        validerButton.setOnClickListener {
            val input = editText.text.toString()
            checkMot(input)
        }


    }

    fun checkMot(answer: String) {
        var toastText: Int
        if (answer == Vocabulaire.getMotAleatoire()) {
            score += 5
            updateScore()
            toastText = R.string.correct_toast
        } else {
            toastText = R.string.incorrect_taost
        }
        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show()
    }

    fun updateScore() {
        scoreText.setText(score.toString())
    }
}