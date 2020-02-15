package com.example.semi_1.Network.Get

import com.example.semi_1.Data.ProductOverviewData

data class GetMainProductListResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: ArrayList<ProductOverviewData>?
)