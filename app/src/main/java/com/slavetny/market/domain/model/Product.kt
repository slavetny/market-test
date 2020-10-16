package com.slavetny.market.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.slavetny.market.data.db.PriceTypeConverter
import java.io.Serializable

@Entity(tableName = "product")
data class Product(
    @PrimaryKey
    val id: Int,
    val brandName: String,
    val colour: String,
    val colourWayId: Int,
    val hasMultiplePrices: Boolean,
    val hasVariantColours: Boolean,
    val imageUrl: String,
    val isSellingFast: Boolean,
    val name: String,
    @TypeConverters(PriceTypeConverter::class)
    val price: Price,
    val productCode: Int,
    val productType: String,
    val url: String
) : Serializable