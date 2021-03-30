package com.example.projet_tdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tp5_v2.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    lateinit var inUsername: EditText;
    lateinit var inPassword: EditText;
    lateinit var btnLogin: Button;
    lateinit var authService: AuthService ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authService = AuthService(getApplicationContext())
        if(authService.fetchAuthToken() != null ){
            this.goToMainActivity();
        }

        inUsername =  findViewById(R.id.inputUsername) as EditText;
        inPassword = findViewById(R.id.inputPassword) as EditText;
        btnLogin = findViewById(R.id.btnLogin) as Button;

        btnLogin.setOnClickListener { view ->
                var username = inUsername.getText().toString();
                var pwd = inPassword.getText().toString();
                if (validateLogin(username, pwd))
                    doLogin(username, pwd)

        }
    }

    private fun validateLogin(username: String?, password: String?): Boolean {
        if (username == null || username.trim { it <= ' ' }.length == 0) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password == null || password.trim { it <= ' ' }.length == 0) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun doLogin(username: String, password: String) {
        val call = RetrofitService.userService.login(LoginRequest(username,password));
        call.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful()) {
                    val authReponse: AuthResponse = response.body() as AuthResponse
                    if ( authReponse?.authToken!= null) {
                        authService.saveAuthToken(authReponse.authToken)
                        goToMainActivity()
                    } else {
                        Toast.makeText(getApplicationContext(), "The username or password is incorrect", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Toast.makeText(getApplicationContext(), t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun goToMainActivity(){
        val intent = Intent(getApplicationContext(), MainActivity::class.java)
        startActivity(intent)
    }
}