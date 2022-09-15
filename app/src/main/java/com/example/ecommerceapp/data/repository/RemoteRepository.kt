package com.example.ecommerceapp.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ecommerceapp.data.local.ProductFavoriteRoomModel
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.data.response.CRUDResponse
import com.example.ecommerceapp.data.retrofit.RemoteDAOInterface
import com.example.ecommerceapp.data.room.ProductFavoriteDAOInterface
import com.example.ecommerceapp.data.room.ProductFavoriteRoomDatabase
import com.example.ecommerceapp.utils.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository(context: Context) {

    var productList = MutableLiveData<List<Products>>()
    var categoryList = MutableLiveData<List<String>>()

    var isLoading = MutableLiveData<Boolean>()
    var status = MutableLiveData<Int>()
    var isProductAddedBasket = MutableLiveData<Boolean>()

    private val remoteDIF: RemoteDAOInterface = ApiUtils.getProductsDAOInterface()

    fun products(){
        isLoading.value = true
        remoteDIF.getAllProducts().enqueue(object : Callback<List<Products>> {
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
        remoteDIF.getProductsByUser(user).enqueue(object : Callback<List<Products>>{
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
        remoteDIF.getCategoriesByUser(user).enqueue(object : Callback<List<String>> {
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

    fun addToBag(user: String, title: String, price: Double, description: String, category: String, image: String, rate: Double, count: Int, sale_state: Int ){
        isLoading.value = true
        remoteDIF.addToBag(user,title,price,description,category,image,rate,count,sale_state).enqueue(object : Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                response.body()?.let {
                    status.value = 1
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("add to bag fail", it) }
                isLoading.value = false
            }
        })
    }

    fun getBagProductsByUser(user: String){
        isLoading.value = true
        remoteDIF.getBagProductsByUser(user).enqueue(object : Callback<List<Products>> {
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
     fun deleteFromBag(id: Int){
        remoteDIF.deleteFromBag(id)
    }

    }


