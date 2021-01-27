package com.tdm.tp5exo1

import Smartphone
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import java.text.NumberFormat
import java.util.*

class SmartphoneDetail : Fragment() {
    private lateinit var smartphoneImageView:ImageView
    private lateinit var smartphoneNameTextView:TextView
    private lateinit var smartphoneSpecsTextView:TextView
    private lateinit var smartphonePriceTextView:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun numberFormat(number: Long): String {
        val nf = NumberFormat.getInstance(Locale("sk", "SK"))
        nf.setGroupingUsed(true)
        return nf.format(number)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smartphone_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val smartphone = arguments?.getSerializable("smartphone") as Smartphone
        smartphoneNameTextView = activity?.findViewById<TextView>(R.id.smartphoneName) as TextView
        smartphoneSpecsTextView = activity?.findViewById<TextView>(R.id.smartphoneSpecs) as TextView
        smartphonePriceTextView = activity?.findViewById<TextView>(R.id.smartphonePrice) as TextView
        smartphoneImageView = activity?.findViewById<ImageView>(R.id.smartphoneImage) as ImageView

        smartphoneNameTextView.text = smartphone.name
        smartphoneSpecsTextView.text = "${smartphone.model} ${smartphone.color}"
        smartphonePriceTextView.text = numberFormat(smartphone.price)
        smartphoneImageView.setImageResource(smartphone.img)
    }

}