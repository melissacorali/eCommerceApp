package com.example.ecommerceapp.presentation.categories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.data.remote.Categories
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.data.repository.CategoryRepository
import com.example.ecommerceapp.data.repository.ProductsRepository
import kotlinx.coroutines.launch

class CategoriesViewModel(context: Context) : ViewModel() {
    private var categoryRepo = CategoryRepository(context)

    private var _categoryList = MutableLiveData<List<Categories>>()
    val categoryList: LiveData<List<Categories>>
        get() = _categoryList


    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
      //  getCategoryByUser("melissacorali")
        getAllCategory()
    }


    fun getCategoryByUser(user: String){
        viewModelScope.launch {
            categoryRepo.getCategoryByUser(user)
            _categoryList = categoryRepo.categoryList
            _isLoading = categoryRepo.isLoading
        }


    }
    fun getAllCategory(){
        categoryRepo.getAllCategory()
        _categoryList = categoryRepo.categoryList
        _isLoading = categoryRepo.isLoading
    }
}