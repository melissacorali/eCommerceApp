package com.example.ecommerceapp.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Products(

    val category: String?,
    val count: String?,
    val description: String?,
    val id: String?,
    val image: String?,
    val price: String?,
    val rate: String?,
    val title: String?,
    val user: String?
) : Parcelable

