package com.example.ecommerceapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ecommerceapp.data.local.ProductFavoriteRoomModel

@Database(entities = [ProductFavoriteRoomModel::class], version = 1)
abstract class ProductFavoriteRoomDatabase : RoomDatabase() {

    abstract fun productFavoriteDAOInterface(): ProductFavoriteDAOInterface

    companion object{
        private var instance: ProductFavoriteRoomDatabase? = null

        fun productFavoriteRoomDatabase(context: Context): ProductFavoriteRoomDatabase?{
        if(instance == null){
            instance = Room.databaseBuilder(
                context,
                ProductFavoriteRoomDatabase::class.java,
                "productfavoritedatabase.db"
            )
                .allowMainThreadQueries()
                .build()
        }
            return instance
        }

    }
}