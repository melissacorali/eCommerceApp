package com.example.ecommerceapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ecommerceapp.data.local.ProductFavoriteRoomModel


@Dao
interface ProductFavoriteDAOInterface {

    @Insert
    fun addFavorite(productFavoriteRoomModel: ProductFavoriteRoomModel)

    @Query("SELECT * FROM productfavoritedatabase")
    fun getFavorite(): List<ProductFavoriteRoomModel>

    @Query("DELETE FROM productfavoritedatabase WHERE id = :idInput ")
    fun deleteProductWithId(idInput: Int)

    @Query("SELECT id FROM productfavoritedatabase  WHERE  id= :idInput")
    fun getFavoriteById(idInput: Int): List<Int>?


}