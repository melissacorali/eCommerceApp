package com.example.ecommerceapp.data.retrofit

import com.example.ecommerceapp.data.remote.Categories
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface CategoriesDAOInterface {

    @POST("get_categories_by_user.php")
    @FormUrlEncoded
    fun getCategoriesByUser(
        @Field("user") user: String): Call<List<Categories>>

    @GET("get_categories.php")
    fun getCategories(): Call<List<Categories>>
}