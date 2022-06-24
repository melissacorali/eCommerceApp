package com.example.ecommerceapp.presentation.basket

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.data.repository.RemoteRepository
import kotlinx.coroutines.launch

class BasketViewModel(context: Context) : ViewModel() {

    private var productsRepo = RemoteRepository(context)

    private var _productsList = MutableLiveData<List<Products>>()
    val productsList: LiveData<List<Products>>
        get() = _productsList


    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getBagProductsByUser("melissacorali")
    }

    fun getBagProductsByUser(user: String){
        viewModelScope.launch {
            productsRepo.getBagProductsByUser(user)
            _productsList = productsRepo.productList
            _isLoading = productsRepo.isLoading

        }
    }

}