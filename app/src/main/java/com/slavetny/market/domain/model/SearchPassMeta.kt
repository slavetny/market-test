package com.slavetny.market.domain.model

data class SearchPassMeta(
    val alternateSearchTerms: List<Any>,
    val isPartial: Boolean,
    val isSpellcheck: Boolean,
    val searchPass: List<Any>
)