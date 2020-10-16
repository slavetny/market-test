package com.slavetny.market.presentation.adapter

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.slavetny.market.R
import com.slavetny.market.domain.model.Product
import kotlinx.android.synthetic.main.product_item.view.*

class ProductsViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    fun bind(product: Product) {
        Glide.with(itemView)
            .load("http://${product.imageUrl}")
            .into(itemView.productPhoto)

        itemView.productTitle.text = product.name
        itemView.productPrice.text = product.price.current.text

        itemView.setOnClickListener {
            itemView.findNavController().navigate(
                R.id.action_productList_to_about,
                bundleOf("product" to product)
            )
        }
    }
}