package com.abdennour.exo2

import Pack
import Product
import Smartphone
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var productName:TextView
    private lateinit var productImage: ImageView
    private lateinit var productPrice: TextView
    private lateinit var productQuantity: TextView
    private lateinit var addButton: ImageView
    private lateinit var minusButton: ImageView
    private lateinit var smartphoneChoix: ImageButton
    private lateinit var packChoix: ImageButton
    private var quantiteS:Int = 0
    private var quanitieP:Int = 0
    private var phones: List<Smartphone> = listOf(
        Smartphone("Redmi Note 8", 9, 32000, "Xiaomi", "Redmi Note 8 6.53\"", "Black", 9)
    )
    private var pack: Pack = Pack("Pack China", 4, 180000, null, null, phones)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productName = findViewById(R.id.product_name)
        productImage = findViewById(R.id.product_image)
        productPrice = findViewById(R.id.product_price)
        productQuantity = findViewById(R.id.product_quantite)
        addButton = findViewById(R.id.add)
        minusButton = findViewById(R.id.minus)
        packChoix = findViewById(R.id.choix_pack)
        smartphoneChoix = findViewById(R.id.choix_smartphone)



        displayProduct(pack)
        packChoix.setOnClickListener {
            displayProduct(pack)
        }
        smartphoneChoix.setOnClickListener {
            displayProduct(phones[0])
        }

    }
    fun displayProduct(product:Product){
        var name:String
        var imageId: Int
        var quantite : Int = 0
        if(product is Smartphone)
        {
            name = "${product.brand} ${product.model} - ${product.color}"
            imageId = R.drawable.ic_phone
            quantite = quantiteS
        }
        else{name = product.name
            imageId = R.drawable.ic_pack
            quantite= quanitieP
        }
        productName.setText(name)
        productImage.setImageResource(imageId)
        productPrice.setText(numberFormat(product.price))
        updateQuantity(quantite)
        addButton.setOnClickListener {
            if(productQuantity.text.toString().toInt()< product.qte)
            {
                quantite++
                if(product is Smartphone) quantiteS = quantite else quanitieP = quantite
                updateQuantity(quantite)
            }
        }
        minusButton.setOnClickListener {
            if (productQuantity.text.toString().toInt()>0)
            {
                quantite--
                if(product is Smartphone) quantiteS = quantite else quanitieP = quantite
                updateQuantity(quantite)
            }
        }
    }

    fun numberFormat(number: Long): String {
        val nf = NumberFormat.getInstance(Locale("sk", "SK"))
        nf.setGroupingUsed(true)
        return nf.format(number)
    }
    fun updateQuantity(qte:Int)
    {
        productQuantity.setText(qte.toString())
    }
}