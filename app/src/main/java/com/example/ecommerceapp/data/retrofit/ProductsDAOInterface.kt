package com.example.ecommerceapp.data.retrofit

import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.data.response.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductsDAOInterface {

    @GET(" get_products.php")
    fun getAllProducts () : Call<ProductsResponse>

}