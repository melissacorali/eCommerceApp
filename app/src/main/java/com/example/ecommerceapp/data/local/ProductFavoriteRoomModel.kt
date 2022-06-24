package com.example.ecommerceapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productfavoritedatabase")
data class ProductFavoriteRoomModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "category")
    var category: String?,

    @ColumnInfo(name = "count")
    var count: String?,

    @ColumnInfo(name = "description")
    var description: String?,

    @ColumnInfo(name = "image")
    var image: String?,

    @ColumnInfo(name = "price")
    var price: String?,

    @ColumnInfo(name = "rate")
    var rate: String?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "user" )
    var user: String?

)
