package com.example.ecommerceapp.data.response

import com.example.ecommerceapp.data.remote.Products
import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("products") var products: List<Products>,
)
