package com.example.projet_tdm

data class Order(var num: Int, var name: String,var status: String, var clientAdress:Localisation, var clientPhoneNumber:String, var clientEmail: String, var priceOrder: Long  ) {
    lateinit var productsList: List<Product>
}