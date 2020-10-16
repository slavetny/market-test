package com.slavetny.market.data.repository

import com.slavetny.market.data.network.Result
import com.slavetny.market.domain.model.Product
import com.slavetny.market.domain.model.Products

interface ProductsRepository {

    suspend fun getProducts(categoryId: String, limit: String): Result<Products>
    suspend fun addProductInCart(product: Product)
    suspend fun getProductsCount(): Int
    suspend fun getProductsFromCart(): Result<List<Product>>
    suspend fun deleteProductFromCart(name: String)

}