package com.example.ecommerceapp.data.retrofit

import com.example.ecommerceapp.data.remote.Products
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductsDAOInterface {

    @GET("get_products.php")
    fun getAllProducts () : Call<List<Products>>

    @POST("get_products_by_user.php")
    @FormUrlEncoded
    fun getProductsByUser(
        @Field("user") user: String,
    ): Call<List<Products>>

    @POST("get_categories_by_user.php")
    @FormUrlEncoded
    fun getCategoriesByUser(@Field("user") user: String): Call<List<String>>
}