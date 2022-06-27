package com.example.ecommerceapp.presentation.basket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.FragmentSuccessBinding


class SuccessFragment : Fragment() {

   private lateinit var binding: FragmentSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentSuccessBinding.inflate(inflater,container,false)
        binding.goHomef.setOnClickListener {
            findNavController().navigate(R.id.action_successFragment_to_homeFragment)
        }
        return binding.root
    }

}