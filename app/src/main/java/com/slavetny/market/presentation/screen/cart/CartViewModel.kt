package com.slavetny.market.presentation.screen.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.slavetny.market.data.repository.ProductsRepository
import com.slavetny.market.domain.model.Product
import com.slavetny.market.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: ProductsRepository
) : BaseViewModel() {

    private val _productsLiveData = MutableLiveData<List<Product>>()
    val productsLiveData: LiveData<List<Product>> get() = _productsLiveData

    private val _productsCountLiveData = MutableLiveData<Int>()
    val productsCountLiveData: LiveData<Int> get() = _productsCountLiveData

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                repository.getProductsFromCart()
            }.onSuccess {
                _productsLiveData.postValue(it.value)
            }.onFailure {
                onHandleError(it.message)
            }
        }
    }

    fun deleteProduct(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteProductFromCart(name)
        }
    }

    fun getProductsCount() {
        viewModelScope.launch(Dispatchers.IO) {
            _productsCountLiveData.postValue(repository.getProductsCount())
        }
    }
}