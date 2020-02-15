package com.example.semi_1.Network

import com.example.semi_1.Network.Get.GetMainProductListResponse
import com.example.semi_1.Network.Post.PostLoginResponse
import com.example.semi_1.Network.Post.PostSignupResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    @POST("/api/auth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type: String,
        @Body() body:JsonObject
    ): Call<PostLoginResponse>

    @POST("/api/auth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type: String,
        @Body() body:JsonObject
    ): Call<PostSignupResponse>

    @GET("/api/webtoons/main/{flag}")
    fun getMainProductListResponse(
        @Header("Content-Type") content_type: String,
        @Path("flag") flag: Int
    ): Call<GetMainProductListResponse>
}
