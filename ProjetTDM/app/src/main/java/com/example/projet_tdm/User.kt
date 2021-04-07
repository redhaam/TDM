package com.example.projet_tdm

data class User(val id:String, var username:String) {
    lateinit var ordersList:List<Order>;
    var ongoingOrdersCount:Int =0;
    var deliveredOrdersCount:Int =0;
    var lateOrdersCount:Int =0;
}