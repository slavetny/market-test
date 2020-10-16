package com.slavetny.market.presentation.base

class Event<out T>(private val data: T) {

    private var hasBeenHandled = false
        private set

    fun updateIfNeed(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            data
        }
    }
}