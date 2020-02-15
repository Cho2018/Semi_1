package com.example.semi_1.Activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.semi_1.R
import com.example.semi_1.DB.SharedPreferenceController
import com.example.semi_1.Network.ApplicationController
import com.example.semi_1.Network.NetworkService
import com.example.semi_1.Network.Post.PostLoginResponse
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    val REQUEST_CODE_LOGIN_ACTIVITY = 1000

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

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

            if(isValid(login_u_id, login_u_pw)) postLoginResponse(login_u_id, login_u_pw)
        }

        txtLoginSignup.setOnClickListener {
            val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val s_time = simpleDateFormat.format(Date())

            val intent: Intent = Intent(this, SignupActivity::class.java)
            intent.putExtra("start_time", s_time)
            startActivityForResult(intent, REQUEST_CODE_LOGIN_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE_LOGIN_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                val e_time = data!!.getStringExtra("end_time")

                //Toast.makeText(this, "End time: ${e_time}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun isValid(u_id: String, u_pw: String): Boolean {
        if(u_id == "") edtLoginID.requestFocus()
        else if(u_pw == "") edtLoginPW.requestFocus()
        else return true
        return false
    }

    fun postLoginResponse(u_id: String, u_pw: String) {
        var jsonObject = JSONObject()
        jsonObject.put("id", u_id)
        jsonObject.put("password", u_pw)

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        val postLoginResponse: Call<PostLoginResponse> =
            networkService.postLoginResponse("application/json", gsonObject)
        postLoginResponse.enqueue(object: Callback<PostLoginResponse> {
            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                Log.e("Login failed", t.toString())
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) {
                if (response.isSuccessful) {
                    if (response.body()!!.status == 201) {
                        SharedPreferenceController.setUserToken(applicationContext, response.body()!!.data!!)
                        finish()
                    }
                }
            }
        })
    }
}
