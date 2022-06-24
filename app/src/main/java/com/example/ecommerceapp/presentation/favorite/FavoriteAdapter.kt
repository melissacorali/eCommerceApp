package com.example.ecommerceapp.presentation.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.data.local.ProductFavoriteRoomModel
import com.example.ecommerceapp.databinding.FavoriteItemBinding
import com.squareup.picasso.Picasso

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteItemDesign>(){

    private val productFavoriteList = ArrayList<ProductFavoriteRoomModel>()
    var onRemoveProductClick: (Int) -> Unit = {}
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteAdapter.FavoriteItemDesign {
        val favoriteItemBinding = FavoriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteItemDesign(favoriteItemBinding)
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.FavoriteItemDesign, position: Int) {
       holder.bind(productFavoriteList[position])
    }

    override fun getItemCount(): Int {
        return try {
            productFavoriteList.size
        } catch (ex: Exception) {
            0
        }
    }

    inner class FavoriteItemDesign(private var favoriteItemBinding: FavoriteItemBinding) :
            RecyclerView.ViewHolder(favoriteItemBinding.root){
                fun bind(product: ProductFavoriteRoomModel){
                    favoriteItemBinding.apply {
                        productModel  = product

                        product.image.let {
                            Picasso.get().load(it).into(imageView2)
                        }
                        remove.setOnClickListener {
                            onRemoveProductClick(product.id)
                        }
                    }
                }
            }

    fun updateList(list: List<ProductFavoriteRoomModel>){
        productFavoriteList.clear()
        productFavoriteList.addAll(list)
        notifyDataSetChanged()
    }

}