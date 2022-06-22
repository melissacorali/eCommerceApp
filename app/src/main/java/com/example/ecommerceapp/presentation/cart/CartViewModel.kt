package com.example.ecommerceapp.presentation.cart

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapp.data.repository.ProductsRepository

class CartViewModel(context: Context) : ViewModel() {

    private val productRepo = ProductsRepository(context)


    fun addToBag(user: String, title: String, price: Double, description: String, category: String, image: String, rate: Double, count: Int, sale_state: Int){
        productRepo.addToBag(user,title,price,description,category,image,rate,count,sale_state)
    }
}