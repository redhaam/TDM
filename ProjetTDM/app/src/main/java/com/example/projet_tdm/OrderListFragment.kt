package com.example.projet_tdm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_order_list.view.*

private lateinit var ordersRecyclerView: RecyclerView

class OrderListFragment : Fragment(R.layout.order_layout) {
    var ordersStatus=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ordersStatus = arguments?.getString("status").toString()



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.ordersRecycleView.layoutManager =LinearLayoutManager(this.context)
        view.ordersRecycleView.adapter = OrderAdapter(requireContext(),getOrders())

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order_list, container, false)
    }

    fun getOrders():List<Order>{
    return AuthService.user.ordersList.filter { order -> order.status== ordersStatus }
    }

}