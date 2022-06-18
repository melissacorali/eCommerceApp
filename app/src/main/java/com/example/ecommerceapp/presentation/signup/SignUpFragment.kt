package com.example.ecommerceapp.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.ecommerceapp.MainActivity
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth


class SignUpFragment : Fragment() {

     private lateinit var binding: FragmentSignUpBinding
     private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater,container,false)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.signuptologin.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmpass = binding.confirmPassEt.text.toString()
            if(email.isNotEmpty() && pass.isNotEmpty() && confirmpass.isNotEmpty()){
                if(pass.equals(confirmpass)){
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(activity, MainActivity::class.java)

                            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
                        } else {
                            Toast.makeText(activity, it.exception.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
                else{
                    Toast.makeText(activity, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(activity, "Please fill in the blanks!", Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }

}