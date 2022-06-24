package com.example.ecommerceapp.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar


fun showSnackbar(view: View, text:Int){
    Snackbar.make(view, text, 1000).show()
}