package com.example.ecommerceapp.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.FragmentEntryBinding

class EntryFragment : Fragment() {

    private lateinit var binding: FragmentEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentEntryBinding.inflate(inflater,container,false)
        binding.signup.setOnClickListener {
            findNavController().navigate(R.id.action_entryFragment_to_signUpFragment)
        }
        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_entryFragment_to_loginFragment)
        }
        return binding.root
    }


}