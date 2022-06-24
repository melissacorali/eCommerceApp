package com.example.ecommerceapp.presentation.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.FragmentCartBinding
import androidx.navigation.fragment.navArgs
import com.example.ecommerceapp.data.local.ProductFavoriteRoomModel
import com.example.ecommerceapp.utils.showSnackbar
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso


class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {CartViewModel(requireContext())}

    private val args: CartFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = args.productModel
        binding.apply {
            productModel = product
            Picasso.get().load(product.image).into(productImage)

            imageback.setOnClickListener {
                it.findNavController().navigateUp()
            }
            addtocard.setOnClickListener {
            viewModel.addToBag(
                user = product.user,
                title = product.title,
                price = product.price.toDouble(),
                description = product.description,
                category = product.category,
                image = product.image,
                rate = product.rate.toDouble(),
                count = product.count.toInt(),
                sale_state = 0

            )

            }
            addToFavorite.setOnClickListener {
            viewModel.addToFavorite(
              ProductFavoriteRoomModel(
                  id = product.id.toInt(),
                  category = product.category,
                  count = product.count,
                  description = product.description,
                  image = product.image,
                  price = product.price,
                  rate = product.rate,
                  title = product.title,
                  user = product.user
              )
            )
            }
           viewModel.isProductAddedFavorite.observe(viewLifecycleOwner){
               if (it)  Snackbar.make(view,R.string.add_favorite_text,Snackbar.LENGTH_LONG).show()
              else Snackbar.make(view,R.string.add_favorite_error,Snackbar.LENGTH_LONG).show()

           }

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}