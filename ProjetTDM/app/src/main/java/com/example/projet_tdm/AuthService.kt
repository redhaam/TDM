package com.example.projet_tdm

import android.content.Context
import android.content.SharedPreferences

class AuthService(context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    fun saveAuthToken(token:String){
        val editor = prefs.edit()
        editor.putString("user_token", token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString("user_token", null)
    }
}