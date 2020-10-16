package com.slavetny.market.di.modules

import com.slavetny.market.data.repository.ProductsRepository
import com.slavetny.market.data.repository.ProductsRepositoryImpl
import com.slavetny.market.presentation.screen.about.AboutViewModel
import com.slavetny.market.presentation.screen.cart.CartViewModel
import com.slavetny.market.presentation.screen.productlist.ProductListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProductListViewModel(get()) }
    viewModel { CartViewModel(get()) }
    viewModel { AboutViewModel(get()) }

    single { ProductsRepositoryImpl(get(), get()) as ProductsRepository }
}