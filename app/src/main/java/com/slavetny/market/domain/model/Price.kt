package com.slavetny.market.domain.model

data class Price(
    val currency: String,
    val isMarkedDown: Boolean,
    val isOutletPrice: Boolean,
    val current: PriceType
)