package com.tdm.tp4exo1

import Smartphone
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.text.NumberFormat
import java.util.*

private lateinit var smartphoneImageView:ImageView
private lateinit var smartphoneNameTextView:TextView
private lateinit var smartphoneSpecsTextView:TextView
private lateinit var smartphonePriceTextView:TextView



class SmartphoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smartphone)
        val smartphone = intent.getSerializableExtra("smartphone") as Smartphone
        smartphoneNameTextView = findViewById<TextView>(R.id.smartphoneName) as TextView
        smartphoneSpecsTextView = findViewById<TextView>(R.id.smartphoneSpecs) as TextView
        smartphonePriceTextView = findViewById<TextView>(R.id.smartphonePrice) as TextView
        smartphoneImageView = findViewById<ImageView>(R.id.smartphoneImage) as ImageView

        smartphoneNameTextView.text = smartphone.name
        smartphoneSpecsTextView.text = "${smartphone.model} ${smartphone.color}"
        smartphonePriceTextView.text = numberFormat(smartphone.price)
        smartphoneImageView.setImageResource(smartphone.img)
    }
    fun numberFormat(number: Long): String {
        val nf = NumberFormat.getInstance(Locale("sk", "SK"))
        nf.setGroupingUsed(true)
        return nf.format(number)
    }
}

