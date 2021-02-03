package com.tdm.tp5exo1

import Product
import Smartphone
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.*

class ProductsAdapter(val context: Context, var data:List<Product>):RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var product:Product = data[position]
        var name:String
        var imageId: Int


        if(product is Smartphone)
        {
            name = "${product.brand} ${product.name} - ${product.color}"
            imageId = R.drawable.ic_phone
            holder.itemView.setOnClickListener {
                if (isDisplayingDetails()){
                    val activity = context as Activity
                    val smartphoneNameTextView = activity.findViewById<TextView>(R.id.smartphoneName) as TextView
                    val smartphoneSpecsTextView = activity.findViewById<TextView>(R.id.smartphoneSpecs) as TextView
                     val smartphonePriceTextView = activity.findViewById<TextView>(R.id.smartphonePrice) as TextView
                    val smartphoneImageView = activity.findViewById<ImageView>(R.id.smartphoneImage) as ImageView

                    smartphoneNameTextView.text = product.name
                    smartphoneSpecsTextView.text = "${product.model} ${product.color}"
                    smartphonePriceTextView.text = numberFormat(product.price)
                    smartphoneImageView.setImageResource(product.img)
                }
                else {
                    val intent = Intent(context, SmartphoneActivity::class.java)
                    intent.putExtra("smartphone", product)
                    context.startActivity(intent)
                }
            }

        }
        else{name = data[position].name
            imageId = R.drawable.ic_pack

        }

        holder.productName.text = name
        holder.productImage.setImageResource(imageId)
        holder.productPrice.text = numberFormat(data[position].price)
        holder.addButton.setOnClickListener {
            if(holder.productQuantity.text.toString().toInt()< product.qte)
            {
                var quantite = holder.productQuantity.text.toString().toInt()
                quantite++
                holder.productQuantity.text = quantite.toString()
                notifyDataSetChanged()
            }
        }
        holder.minusButton.setOnClickListener {
            if (holder.productQuantity.text.toString().toInt()>0)
            {
                var quantite = holder.productQuantity.text.toString().toInt()
                quantite--
                holder.productQuantity.text = quantite.toString()
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount() = data.size
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun isDisplayingDetails(): Boolean{
    val activity= context as Activity;
     return   activity.findViewById<View>(R.id.fragment3) != null;
    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

     val productName = view.findViewById<TextView>(R.id.product_name) as TextView
     val productImage = view.findViewById<ImageView>(R.id.product_image) as ImageView
     val productPrice = view.findViewById<TextView>(R.id.product_price) as TextView
     val productQuantity = view.findViewById<TextView>(R.id.product_quantite) as TextView
     val addButton=view.findViewById<ImageView>(R.id.add) as ImageView
     val minusButton= view.findViewById<ImageView>(R.id.minus) as ImageView


}

fun numberFormat(number: Long): String {
    val nf = NumberFormat.getInstance(Locale("sk", "SK"))
    nf.setGroupingUsed(true)
    return nf.format(number)
}
