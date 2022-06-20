package com.example.ecommerceapp.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ecommerceapp.data.remote.Categories
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.data.retrofit.CategoriesDAOInterface
import com.example.ecommerceapp.utils.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryRepository(context: Context) {
    var categoryList = MutableLiveData<List<Categories>>()

    var isLoading = MutableLiveData<Boolean>()

    private val CategoryDIF: CategoriesDAOInterface = ApiUtils.getCategoryDAOInterface()

    fun getCategoryByUser(user: String){
        isLoading.value = true
        CategoryDIF.getCategoriesByUser(user).enqueue(object : Callback<List<Categories>> {
            override fun onResponse(
                call: Call<List<Categories>>,
                response: Response<List<Categories>>
            ) {
                response.body()?.let {
                    categoryList.value = it
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<List<Categories>>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Products fail", it) }
                isLoading.value = false
            }
        })
    }
    fun getAllCategory(){
        isLoading.value = true
        CategoryDIF.getCategories().enqueue(object : Callback<List<Categories>> {
            override fun onResponse(
                call: Call<List<Categories>>,
                response: Response<List<Categories>>
            ) {
                response.body()?.let {
                    categoryList.value = it
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<List<Categories>>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Products fail", it) }
                isLoading.value = false
            }
        })
    }

}