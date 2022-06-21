package com.example.ecommerceapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.databinding.ProductsItemBinding
import com.squareup.picasso.Picasso

class HomeProductAdapter: RecyclerView.Adapter<HomeProductAdapter.ProductItemDesign>() {

    private val productsList = ArrayList<Products>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):ProductItemDesign {
      val productsItemBinding = ProductsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductItemDesign(productsItemBinding)
    }

    override fun onBindViewHolder(holder:ProductItemDesign, position: Int) {
       holder.bind(productsList[position])
    }


      inner class ProductItemDesign(private var productsItemBinding: ProductsItemBinding) :
              RecyclerView.ViewHolder(productsItemBinding.root){

                  fun bind(product: Products){
                      productsItemBinding.apply {
                          productModel = product

                          product.image.let {
                            Picasso.get().load(it).into(productsImageView)
                          }
                          productsImageView.setOnClickListener {
                              var action = HomeFragmentDirections.actionHomeFragmentToCartFragment(product)
                                it.findNavController().navigate(action)
                          }
                      }

                  }

              }


    fun updateList(list: List<Products>){
        productsList.clear()
        productsList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return try {
            productsList.size
        } catch (ex: Exception) {
            0
        }

    }
}