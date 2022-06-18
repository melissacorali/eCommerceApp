package com.example.ecommerceapp.utils

import com.example.ecommerceapp.data.retrofit.ProductsDAOInterface
import com.example.ecommerceapp.data.retrofit.RetrofitClient
import com.example.ecommerceapp.utils.Constants.BASE_URL

class ApiUtils {

    companion object {

        fun getProductsDAOInterface(): ProductsDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(ProductsDAOInterface::class.java)
        }
    }
}