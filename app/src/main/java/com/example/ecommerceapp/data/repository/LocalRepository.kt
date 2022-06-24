package com.example.ecommerceapp.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.ecommerceapp.data.local.ProductFavoriteRoomModel
import com.example.ecommerceapp.data.room.ProductFavoriteDAOInterface
import com.example.ecommerceapp.data.room.ProductFavoriteRoomDatabase

class LocalRepository(context: Context) {

    var productFavoriteList = MutableLiveData<List<ProductFavoriteRoomModel>>()
    var isProductAddedFavorite = MutableLiveData<Boolean>()
    private val localDIF: ProductFavoriteDAOInterface? = ProductFavoriteRoomDatabase.productFavoriteRoomDatabase(context)?.productFavoriteDAOInterface()
    var isLoading = MutableLiveData<Boolean>()


    fun getFavorites(){
        isLoading.value = true

        localDIF?.getFavorite()?.let {
            productFavoriteList.value = it
            isLoading.value = false
        }?: run{
            isLoading.value = false
        }
    }

    fun addToFavorites(productmodel: ProductFavoriteRoomModel){
        localDIF?.getFavoriteById(productmodel.id)?.let {
            isProductAddedFavorite.value = if (it.contains(productmodel.id).not()){
                localDIF.addFavorite(productmodel)
                true
            } else {
                false
            }
        }
    }

    fun deleteFavorite(productId: Int){
        localDIF?.deleteProductWithId(productId)
    }
}