package com.slavetny.market.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slavetny.market.R
import com.slavetny.market.domain.extensions.inflate
import com.slavetny.market.domain.model.Product

class ProductsAdapter : RecyclerView.Adapter<ProductsViewHolder>() {

    private var productsList: List<Product> = listOf()

    fun attachData(productsList: List<Product>) {
        this.productsList = productsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductsViewHolder(
            parent.inflate(R.layout.product_item)
        )

    override fun getItemCount() = productsList.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(productsList[position])
    }
}