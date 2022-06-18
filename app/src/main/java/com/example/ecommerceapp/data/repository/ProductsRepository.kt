package com.example.ecommerceapp.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.data.response.ProductsResponse
import com.example.ecommerceapp.data.retrofit.ProductsDAOInterface
import com.example.ecommerceapp.utils.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsRepository(context: Context) {

    var productList = MutableLiveData<List<Products>>()

    var isLoading = MutableLiveData<Boolean>()

    private val productsDIF: ProductsDAOInterface = ApiUtils.getProductsDAOInterface()

    fun products(){
        isLoading.value = true
        productsDIF.getAllProducts().enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(call: Call<ProductsResponse>, response: Response<ProductsResponse>) {
                response.body()?.products?.let {
                    productList.value = it
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false

                }
            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Products Fail", it)}
                isLoading.value  = false
            }
        })

    }



}