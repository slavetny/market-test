package com.slavetny.market.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.slavetny.market.domain.model.Product

@Database(entities = [Product::class], version = 1)
@TypeConverters(PriceTypeConverter::class)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductsDao
}