package com.tdm.tp4exo1

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
        Smartphone("Redmi Note 8", 9, 32000, "Xiaomi", "Ecran 6.53\" 4GB 64GB/128GB 48MP Quad camera/Snapdragon 665 Octa Core/4000mAh", "White", 9,R.drawable.xiaomi_redmi_note_8),
         Smartphone("Poco X3", 5, 4600, "Xiaomi", "Ecran 6.67\" 6GB 64GB/128GB 64MP Quad camera/Snapdragon 732G Octa Core/5160mAh", "Black", 5,R.drawable.xiaomi_poco_x3)
    )
     var pack: Pack = Pack("Pack China Premuim", 4, 180000, null, null, phones)

    val products = mutableListOf<Product>()
    products.add(pack)
    products.add(phones[(0..1).random()])
    products.add(phones[(0..1).random()])
    products.add(phones[(0..1).random()])
    products.add(pack)
    products.add(phones[(0..1).random()])
    products.add(phones[(0..1).random()])
    products.add(phones[(0..1).random()])
    products.add(phones[(0..1).random()])
    products.add(phones[(0..1).random()])
    products.add(phones[(0..1).random()])
    products.add(phones[(0..1).random()])
    products.add(phones[(0..1).random()])


    return products
}

