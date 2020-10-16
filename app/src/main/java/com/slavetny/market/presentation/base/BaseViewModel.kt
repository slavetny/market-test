package com.slavetny.market.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    private val _shimmerLiveData = MutableLiveData<Event<Boolean>>()
    val shimmerLiveData: LiveData<Event<Boolean>> get() = _shimmerLiveData

    open fun onCreate() {}

    open fun onViewCreated() {}

    open fun onDestroyView() {}

    open fun onDestroy() {}

    fun onHandleError(message: String?) {
        _errorLiveData.value = message
    }

    fun showShimmer() {
        _shimmerLiveData.value = Event(true)
    }

    fun hideShimmer() {
        _shimmerLiveData.value = Event(false)
    }
}