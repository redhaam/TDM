package com.example.projet_tdm

data class Order(var numOrder: Int, var nameOrder: String,var statusOrder: String, var clientAdress:Localisation, var clientPhoneNumber:String, var clientEmail: String, var priceOrder: Long  ) {
    lateinit var productsList: List<Product>
}