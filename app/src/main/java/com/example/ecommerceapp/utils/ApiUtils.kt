package com.example.ecommerceapp.utils

import com.example.ecommerceapp.data.retrofit.RemoteDAOInterface
import com.example.ecommerceapp.data.retrofit.RetrofitClient
import com.example.ecommerceapp.utils.Constants.BASE_URL

class ApiUtils {

    companion object {

        fun getProductsDAOInterface(): RemoteDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(RemoteDAOInterface::class.java)
        }

    }


}