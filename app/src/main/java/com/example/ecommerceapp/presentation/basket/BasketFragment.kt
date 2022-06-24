package com.example.ecommerceapp.presentation.basket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.FragmentBasketBinding


class BasketFragment : Fragment() {
    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy { BasketViewModel(requireContext()) }
    private val basketAdapter by lazy {BasketAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_basket,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBagProductsByUser(user = "melissacorali")
        initObservers()

    }

    private fun initObservers(){
        with(binding){
            with(viewModel){
                isLoading.observe(viewLifecycleOwner){
                    if(!it) LoadingView.visibility = View.GONE
                }
                productsList.observe(viewLifecycleOwner){
                    list ->
                    recyclerView.apply {
                        setHasFixedSize(true)
                        adapter = basketAdapter.also {
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