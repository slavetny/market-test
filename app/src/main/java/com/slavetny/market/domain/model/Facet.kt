package com.slavetny.market.domain.model

data class Facet(
    val displayStyle: String,
    val facetType: String,
    val facetValues: List<FacetValue>,
    val hasSelectedValues: Boolean,
    val id: String,
    val name: String
)