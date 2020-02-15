package com.example.semi_1.Network.Post

data class PostLoginResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: String?
)