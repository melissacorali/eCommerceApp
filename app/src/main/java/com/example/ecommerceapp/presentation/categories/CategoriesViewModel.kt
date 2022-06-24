package com.example.ecommerceapp.presentation.categories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.data.repository.RemoteRepository
import kotlinx.coroutines.launch

class CategoriesViewModel(context: Context) : ViewModel() {
    private var categoryRepo = RemoteRepository(context)

    private var _categoryList = MutableLiveData<List<String>>()
    val categoryList: LiveData<List<String>>
        get() = _categoryList


    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getCategoryByUser("melissacorali")

    }


    fun getCategoryByUser(user: String){
        viewModelScope.launch {
            categoryRepo.getCategoryByUser(user)
            _categoryList = categoryRepo.categoryList
            _isLoading = categoryRepo.isLoading
        }


    }

}