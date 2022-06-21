package com.example.ecommerceapp.presentation.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.FragmentCategoriesBinding


class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {CategoriesViewModel(requireContext())}
    private val categoriesAdapter by lazy { CategoriesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCategoryByUser(user = "melissacorali")
        initObservers()
    }
    private fun initObservers() {
        with(binding){
            with(viewModel){

                categoryList.observe(viewLifecycleOwner){list ->
                    CategoryrecyclerView.apply {
                        setHasFixedSize(true)
                        adapter = categoriesAdapter.also {
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