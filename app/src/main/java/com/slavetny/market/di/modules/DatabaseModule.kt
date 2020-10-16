package com.slavetny.market.di.modules

import android.app.Application
import androidx.room.Room
import com.slavetny.market.data.db.ProductsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { provideDatabase(androidApplication()) }
    single { provideProductsDao(get()) }
}

fun provideDatabase(application: Application) =
    Room.databaseBuilder(application.applicationContext,
        ProductsDatabase::class.java, "products.db")
        .build()


fun provideProductsDao(database: ProductsDatabase) =
    database.productsDao()