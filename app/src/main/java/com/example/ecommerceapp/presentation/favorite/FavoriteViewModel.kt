package com.example.ecommerceapp.presentation.favorite

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapp.data.local.ProductFavoriteRoomModel
import com.example.ecommerceapp.data.repository.LocalRepository

class FavoriteViewModel(context: Context) : ViewModel() {
    private val localRepo = LocalRepository(context)

    private var _productFavorite = MutableLiveData<List<ProductFavoriteRoomModel>>()
    val productFavorite: LiveData<List<ProductFavoriteRoomModel>>
        get() = _productFavorite
    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init{
        getFavorite()
    }
    private fun getFavorite(){
        localRepo.getFavorites()
        _productFavorite = localRepo.productFavoriteList
        _isLoading = localRepo.isLoading
    }


    fun deleteFavorites(id: String){
        localRepo.deleteFavorite(id.toInt())
        getFavorite()
    }


}