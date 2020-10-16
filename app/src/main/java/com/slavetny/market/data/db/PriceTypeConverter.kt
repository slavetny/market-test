package com.slavetny.market.data.db

import androidx.room.TypeConverter
import com.slavetny.market.domain.model.Price
import com.slavetny.market.domain.model.PriceType

class PriceTypeConverter {
    @TypeConverter
    fun toString(price: Price): Double =
        price.current.value

    @TypeConverter
    fun toPrice(price: Double): Price =
        Price(currency = "USD", isMarkedDown = false,
            isOutletPrice = false, current = PriceType("$price$", price))
}