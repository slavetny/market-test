package com.slavetny.market.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Products(
    val campaigns: Campaigns,
    val categoryName: String,
    val diagnostics: Diagnostics,
    val discoverSearchProductTypes: List<Any>,
    val facets: List<Facet>,
    val itemCount: Int,
    val products: List<Product>,
    val queryId: Any,
    val redirectUrl: String,
    val searchPassMeta: SearchPassMeta,
    val searchTerm: String
)