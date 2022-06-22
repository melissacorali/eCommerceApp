package com.example.ecommerceapp.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CRUDResponse(
    val message : String?,
    val status : Int?
) : Parcelable
