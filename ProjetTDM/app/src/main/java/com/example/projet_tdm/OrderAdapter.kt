package com.example.projet_tdm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_tdm.R

class OrderAdapter(val context: Context, var data:List<Order>): RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.order_layout, parent, false))
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.orderName.text = data[position].name
        holder.orderNumber.text = "#"+data[position].num.toString()
        //holder.itemView.setOnClickListener {  }
    }

    override fun getItemCount(): Int = data.size


}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
   val orderName = view.findViewById<TextView>(R.id.order_name) as TextView
   val orderNumber = view.findViewById<TextView>(R.id.order_number) as TextView
}
