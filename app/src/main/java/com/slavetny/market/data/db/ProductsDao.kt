package com.slavetny.market.data.db

import androidx.room.*
import com.slavetny.market.domain.model.Product

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product)

    @Query("SELECT * FROM product")
    fun getProducts(): List<Product>

    @Query("SELECT COUNT(*) FROM product")
    fun getProductsCount(): Int

    @Query("DELETE FROM product WHERE name = :name")
    fun delete(name: String)
}