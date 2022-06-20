package com.example.ecommerceapp.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth


class HomeFragment : Fragment() {

       private var _binding: FragmentHomeBinding? = null
       private val binding get() = _binding!!

       private val viewModel by lazy { HomeViewModel(requireContext())}
       private val homeProductAdapter by lazy {HomeProductAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProductByUser(user = "melissacorali")
        initObservers()
    }

    private fun initObservers() {
        with(binding){
            with(viewModel){

                isLoading.observe(viewLifecycleOwner){
                    if(!it) LoadingView.visibility = View.GONE
                }

                productsList.observe(viewLifecycleOwner) { list ->

                      productsRecycler.apply {
                        setHasFixedSize(true)
                    adapter = homeProductAdapter.also {
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