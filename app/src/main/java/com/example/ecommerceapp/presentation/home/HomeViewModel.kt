package com.example.ecommerceapp.presentation.home
import android.content.Context
import androidx.lifecycle.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.data.repository.RemoteRepository
import kotlinx.coroutines.launch


class HomeViewModel(context: Context) : ViewModel() {

    private var productsRepo = RemoteRepository(context)

    private var _productsList = MutableLiveData<List<Products>>()
    val productsList: LiveData<List<Products>>
    get() = _productsList


    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getProductByUser("melissacorali")
       // getAllProducts()
    }

    private fun getAllProducts(){
        productsRepo.products()
        _productsList = productsRepo.productList
        _isLoading = productsRepo.isLoading
    }

     fun getProductByUser(user: String){
         viewModelScope.launch {
             productsRepo.getProductByUser(user)
             _productsList = productsRepo.productList
             _isLoading = productsRepo.isLoading
         }


    }

}




