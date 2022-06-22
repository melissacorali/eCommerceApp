package com.example.ecommerceapp.presentation.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.data.remote.Products
import com.example.ecommerceapp.databinding.CategoriesItemBinding

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoryItemDesign>() {

    private val categoryList = ArrayList<String>()
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

        fun bind(category: String){
            categoriesItemBinding.apply {
                categoryModel = category

                ProductsTitle.setOnClickListener {
                    val action = CategoriesFragmentDirections.actionCategoriesFragmentToProductFragment(category)
                    it.findNavController().navigate(action)
                }
            }
        }

    }

    fun updateList(list: List<String>){
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