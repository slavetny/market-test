package com.slavetny.market.domain.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.slavetny.market.presentation.base.Event

inline fun <T> LiveData<Event<T>>.observeEvent(
    owner: LifecycleOwner,
    crossinline onHandleEvent: (T) -> Unit
) {
    observe(owner, Observer { it?.updateIfNeed()?.let(onHandleEvent) })
}

inline fun <T> LiveData<T>.observeNotNull(
    owner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    observe(owner, Observer { it?.let { observer.invoke(it) } })
}