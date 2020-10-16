package com.slavetny.market.presentation.screen.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.slavetny.market.data.repository.ProductsRepository
import com.slavetny.market.domain.model.Products
import com.slavetny.market.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class ProductListViewModel(
    private val repository: ProductsRepository
) : BaseViewModel() {

    private val _productsLiveData = MutableLiveData<Products>()
    val productsLiveData: LiveData<Products> get() = _productsLiveData

    init {
        showShimmer()

        viewModelScope.launch {
            runCatching {
                repository.getProducts("4209", "48")
            }.onSuccess {
                _productsLiveData.value = it.value
                hideShimmer()
            }.onFailure {
                onHandleError(it.message)
                hideShimmer()
            }
        }
    }
}