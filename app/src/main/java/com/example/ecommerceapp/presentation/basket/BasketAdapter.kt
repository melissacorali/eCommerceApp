package com.example.ecommerceapp.presentation.basket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.databinding.BasketItemBinding
import com.squareup.picasso.Picasso
import java.lang.StringBuilder

class BasketAdapter: RecyclerView.Adapter<BasketAdapter.BasketItemDesign>() {

    private val productList = ArrayList<Products>()
    var onRemoveProductClick: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketAdapter.BasketItemDesign {
       val basketItemBinding = BasketItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BasketItemDesign(basketItemBinding)
    }

    override fun onBindViewHolder(holder: BasketAdapter.BasketItemDesign, position: Int) {
       holder.bind(productList[position])


    }
    inner class BasketItemDesign(private var basketItemBinding: BasketItemBinding) :
            RecyclerView.ViewHolder(basketItemBinding.root){
                fun bind(product: Products){
                    basketItemBinding.apply {
                        var count = number.text.toString().toInt()
                        productModel = product
                        imageButton.setOnClickListener {
                            count++
                             number.text = count.toString()
                            favoritePrice.text = ((count * product.price.toInt()).toString()) + " ₺".toString()
                        }
                        imageButton2.setOnClickListener {
                            count--
                            number.text = count.toString()
                            favoritePrice.text = ((count * product.price.toInt()).toString()) + " ₺".toString()
                        }

                        product.image.let {
                            Picasso.get().load(it).into(imageView2)
                        }
                        delete.setOnClickListener {
                    onRemoveProductClick(product.id.toInt())
                        }


                    }

                }
    }

    fun updateList(list: List<Products>){
        productList.clear()
        productList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return try {
            productList.size
        } catch (ex: Exception) {
            0
        }
    }

}