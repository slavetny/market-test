package com.slavetny.market.domain.model

data class Diagnostics(
    val processingTime: Int,
    val queryTime: Int,
    val recommendationsAnalytics: RecommendationsAnalytics,
    val recommendationsEnabled: Boolean,
    val requestId: String
)