package com.tdm.tp3

import Pack
import Product
import Smartphone
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import android.os.Bundle

private lateinit var productRecyclerView: RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        productRecyclerView = findViewById(R.id.productsRecyclerView)
        productRecyclerView.layoutManager = LinearLayoutManager(this)
        productRecyclerView.adapter = ProductsAdapter(this,loadData())
    }
}
fun loadData():List<Product> {
     var phones: List<Smartphone> = listOf(
        Smartphone("Redmi Note 8", 9, 32000, "Xiaomi", "Redmi Note 8 6.53\"", "Black", 9)
    )
     var pack: Pack = Pack("Pack China Premuim", 4, 180000, null, null, phones)

    val products = mutableListOf<Product>()
    products.add(pack)
    products.add(phones[0])
    products.add(phones[0])
    products.add(phones[0])
    products.add(pack)
    products.add(phones[0])
    products.add(phones[0])
    products.add(phones[0])
    products.add(phones[0])
    products.add(phones[0])
    products.add(phones[0])
    products.add(phones[0])
    products.add(phones[0])


    return products
}

