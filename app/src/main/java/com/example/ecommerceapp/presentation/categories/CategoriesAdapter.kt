package com.example.ecommerceapp.presentation.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.data.remote.Categories
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.databinding.CategoriesItemBinding
import com.example.ecommerceapp.databinding.ProductsItemBinding
import com.squareup.picasso.Picasso

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoryItemDesign>() {

    private val categoryList = ArrayList<Categories>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.CategoryItemDesign {
        val categoriesItemBinding = CategoriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryItemDesign(categoriesItemBinding)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.CategoryItemDesign, position: Int) {
        holder.bind(categoryList[position])
    }



    inner class CategoryItemDesign(private var categoriesItemBinding: CategoriesItemBinding) :
        RecyclerView.ViewHolder(categoriesItemBinding.root){

        fun bind(category: Categories){
            categoriesItemBinding.apply {
                categoryModel = category

            }
        }

    }

    fun updateList(list: List<Categories>){
        categoryList.clear()
        categoryList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return try {
            categoryList.size
        } catch (ex: Exception) {
            0
        }

    }
}