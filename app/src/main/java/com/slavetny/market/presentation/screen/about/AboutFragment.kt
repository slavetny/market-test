package com.slavetny.market.presentation.screen.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.slavetny.market.databinding.FragmentAboutBinding
import com.slavetny.market.domain.model.Product
import com.slavetny.market.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class AboutFragment : BaseFragment<AboutViewModel, FragmentAboutBinding>() {

    override val viewModel: AboutViewModel by viewModel()

    private var product: Product? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product = arguments?.get("product") as Product

        initViews()

        binding?.cartButton?.setOnClickListener {
            viewModel.addToCart(product!!)
            Toast.makeText(requireContext(), "Added to Cart", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViews() {
        binding?.productPhoto?.let {
            Glide.with(this)
                .load("http://${product?.imageUrl}")
                .into(it)
        }

        binding?.productTitle?.text = product?.name
        binding?.productPrice?.text = product?.price?.current?.text
        binding?.productDescription?.text = product?.brandName
    }

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentAboutBinding =
        FragmentAboutBinding.inflate(inflater, container, false)
}