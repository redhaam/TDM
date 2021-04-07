package com.example.projet_tdm

import android.content.Context
import android.content.SharedPreferences
import com.example.projet_tdm.R

class AuthService(context: Context) {

    companion object {
        var authToken:String?=null;
        lateinit var user:User
    }
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    fun saveAuthToken(token:String){
        AuthService.authToken=token
        val editor = prefs.edit()
        editor.putString("user_token", token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        authToken = prefs.getString("user_token", null)
        return authToken
    }
}