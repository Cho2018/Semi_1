package com.example.semi_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtLoginID.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        edtLoginPW.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        btnLoginSubmit.setOnClickListener {
            val login_u_id = edtLoginID.text.toString()
            val login_u_pw: String = edtLoginPW.text.toString()

            if(login_u_id == "") edtLoginID.requestFocus()
            else if(login_u_pw == "") edtLoginPW.requestFocus()
            else postLoginResponse(login_u_id, login_u_pw)
        }

        txtLoginSignup.setOnClickListener{
            val intent: Intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    fun postLoginResponse(u_id: String, u_pw: String){
        finish()
    }
}
