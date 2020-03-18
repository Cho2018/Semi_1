package com.example.semi_1.Network

import com.example.semi_1.Network.Get.GetMainProductListResponse
import com.example.semi_1.Network.Post.PostCommentResponse
import com.example.semi_1.Network.Post.PostLoginResponse
import com.example.semi_1.Network.Post.PostSignupResponse
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    @POST("/auth/signin")
    fun postLoginResponse(
        @Header("token") token: String,
        @Body() body:JsonObject
    ): Call<PostLoginResponse>

    @POST("/auth/signup")
    fun postSignupResponse(
        @Header("token") token: String,
        @Body() body:JsonObject
    ): Call<PostSignupResponse>

    @GET("/webtoons/main/{flag}")
    fun getMainProductListResponse(
        @Header("token") token: String,
        @Path("flag") flag: Int
    ): Call<GetMainProductListResponse>

    @Multipart
    @POST("/webtoons/episodes/cmts")
    fun postCommentResponse(
        @Header("token") token: String,

        @Part("epIdx") epIdx: Int,
        @Part("content") content: RequestBody,
        @Part cmtImg: MultipartBody.Part?
    ): Call<PostCommentResponse>
}
