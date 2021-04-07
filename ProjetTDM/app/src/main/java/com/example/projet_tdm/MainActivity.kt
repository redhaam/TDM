package com.example.projet_tdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var call = RetrofitService.orderService.getOrders("Bearer "+AuthService.authToken)
        call.enqueue(object: Callback<List<Order>> {
            override fun onResponse(call: Call<List<Order>>, response: Response<List<Order>>) {
                if (response.isSuccessful()){
                    var orders = response.body() as List<Order>
                    AuthService.user.ordersList = orders
                }
            }

            override fun onFailure(call: Call<List<Order>>, t: Throwable) {

            }
        })

    }








}