package com.tdm.tp5exo1

import Pack
import Product
import Smartphone
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsFragment : Fragment() {
    private lateinit var productRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        productRecyclerView = activity?.findViewById(R.id.productsList) as RecyclerView
        productRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        productRecyclerView.adapter = ProductsAdapter(requireActivity(),loadData())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_products, container, false)
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

}