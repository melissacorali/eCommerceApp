package com.example.ecommerceapp.presentation.cart

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapp.data.local.ProductFavoriteRoomModel
import com.example.ecommerceapp.data.repository.LocalRepository
import com.example.ecommerceapp.data.repository.RemoteRepository

class CartViewModel(context: Context) : ViewModel() {

    private val productRepo = RemoteRepository(context)
    private val localRepo = LocalRepository(context)
    private var _isProductAddedFavorite = MutableLiveData<Boolean>()
    val isProductAddedFavorite: LiveData<Boolean>
    get() = _isProductAddedFavorite

    fun addToBag(user: String, title: String, price: Double, description: String, category: String, image: String, rate: Double, count: Int, sale_state: Int){
        productRepo.addToBag(user,title,price,description,category,image,rate,count,sale_state)
    }

    fun addToFavorite(productmodel: ProductFavoriteRoomModel){
        localRepo.addToFavorites(productmodel)

    }

    init {
        _isProductAddedFavorite = localRepo.isProductAddedFavorite
    }
}