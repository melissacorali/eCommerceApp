package com.example.ecommerceapp.presentation.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy { FavoriteViewModel(requireContext()) }
    private val favoriteAdapter by lazy { FavoriteAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_favorite,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            recyclerView.setHasFixedSize(true)
            favoriteAdapter.onRemoveProductClick = {

                viewModel.deleteFavorites(it.toString())
            }
        }
        initObservers()
    }

    private fun initObservers(){
        with(binding){
            with(viewModel){
                isLoading.observe(viewLifecycleOwner){
                    if(!it) LoadingView.visibility = View.GONE
                }
                productFavorite.observe(viewLifecycleOwner){
                    list->
                    recyclerView.apply {
                        setHasFixedSize(true)
                        adapter = favoriteAdapter.also {
                            it.updateList(list)
                        }
                    }
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}