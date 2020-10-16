package com.slavetny.market.presentation.screen.about

import androidx.lifecycle.viewModelScope
import com.slavetny.market.data.repository.ProductsRepository
import com.slavetny.market.domain.model.Product
import com.slavetny.market.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AboutViewModel(
    private val repository: ProductsRepository
) : BaseViewModel() {

    fun addToCart(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProductInCart(product)
        }
    }
}