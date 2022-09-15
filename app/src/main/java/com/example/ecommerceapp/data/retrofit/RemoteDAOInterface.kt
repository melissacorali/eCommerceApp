package com.example.ecommerceapp.data.retrofit

import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.data.response.CRUDResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RemoteDAOInterface {

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

    @POST("add_to_bag.php ")
        @FormUrlEncoded
        fun addToBag(
        @Field("user") user: String,
        @Field("title") title: String,
        @Field("price") price: Double,
        @Field("description") description: String,
        @Field("category") category: String,
        @Field("image") image: String,
        @Field("rate") rate: Double,
        @Field("count") count: Int,
        @Field("sale_state") sale_state: Int,
    ): Call<CRUDResponse>

    @POST("get_bag_products_by_user.php")
        @FormUrlEncoded
        fun getBagProductsByUser(
            @Field(" user") user: String,
            ): Call<List<Products>>

    @POST("delete_to_bag.php")
        @FormUrlEncoded
        fun deleteFromBag(
            @Field("id") id: Int,
        ): Call<CRUDResponse>

}