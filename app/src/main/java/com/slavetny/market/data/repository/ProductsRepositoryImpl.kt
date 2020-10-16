package com.slavetny.market.data.repository

import com.slavetny.market.data.db.ProductsDao
import com.slavetny.market.data.network.ProductsService
import com.slavetny.market.data.network.Result
import com.slavetny.market.domain.model.Product

class ProductsRepositoryImpl(
    private val productsService: ProductsService,
    private val productsDao: ProductsDao
) : ProductsRepository {

    override suspend fun getProducts(categoryId: String, limit: String) =
        Result(productsService.getProductsList(categoryId, limit))

    override suspend fun addProductInCart(product: Product) =
        productsDao.insert(product)

    override suspend fun getProductsCount() =
        productsDao.getProductsCount()

    override suspend fun getProductsFromCart() =
        Result(productsDao.getProducts())

    override suspend fun deleteProductFromCart(name: String) =
        productsDao.delete(name)

}