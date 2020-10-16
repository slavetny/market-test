package com.slavetny.market.domain.model

data class RecommendationsAnalytics(
    val items: List<Any>,
    val numberOfItems: Int,
    val numberOfRecs: Int,
    val personalisationStatus: Int,
    val personalisationType: String
)