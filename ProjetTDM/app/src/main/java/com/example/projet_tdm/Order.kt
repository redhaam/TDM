package com.example.projet_tdm

data class Order(var num: Int, var name: String,var status: String, var client:Client,var deliveryAdress: Localisation, var cost: Long  ) {
    lateinit var productsList: List<Product>
}