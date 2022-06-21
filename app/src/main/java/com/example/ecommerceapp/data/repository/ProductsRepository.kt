package com.example.ecommerceapp.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.data.response.ProductsResponse
import com.example.ecommerceapp.data.retrofit.ProductsDAOInterface
import com.example.ecommerceapp.utils.ApiUtils
import kotlinx.coroutines.coroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Field

class ProductsRepository(context: Context) {

    var productList = MutableLiveData<List<Products>>()
    var categoryList = MutableLiveData<List<String>>()

    var isLoading = MutableLiveData<Boolean>()


    private val productsDIF: ProductsDAOInterface = ApiUtils.getProductsDAOInterface()

    fun products(){
        isLoading.value = true
        productsDIF.getAllProducts().enqueue(object : Callback<List<Products>> {
            override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
                response.body()?.let {
                    productList.value = it
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false

                }
            }

            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Products Fail", it)}
                isLoading.value  = false
            }
        })

    }

    fun getProductByUser(user: String) {
        isLoading.value = true
        productsDIF.getProductsByUser(user).enqueue(object : Callback<List<Products>>{
            override fun onResponse(
                call: Call<List<Products>>,
                response: Response<List<Products>>
            ) {
                response.body()?.let {
                    productList.value = it
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Products fail", it) }
                isLoading.value = false
            }
        })

    }
    fun getCategoryByUser(user: String){
        isLoading.value = true
        productsDIF.getCategoriesByUser(user).enqueue(object : Callback<List<String>> {
            override fun onResponse(
                call: Call<List<String>>,
                response: Response<List<String>>
            ) {
                response.body()?.let {
                    categoryList.value = it
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Products fail", it) }
                isLoading.value = false
            }
        })
    }


}