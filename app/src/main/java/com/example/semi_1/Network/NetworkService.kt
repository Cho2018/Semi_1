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

    @Multipart
    @POST("/api/webtoons/episodes/cmts")
    fun postCommentResponse(
        @Header("token") token: String,

        @Part("epIdx") epIdx: Int,
        @Part("content") content: RequestBody,
        @Part cmtImg: MultipartBody.Part
    ): Call<PostCommentResponse>
}
