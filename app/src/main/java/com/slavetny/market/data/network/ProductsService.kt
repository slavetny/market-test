package com.slavetny.market.data.network

import com.slavetny.market.domain.constants.Constants
import com.slavetny.market.domain.model.Products
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ProductsService {

    @Headers("x-rapidapi-key:" + Constants.API_KEY)
    @GET("products/v2/list")
    suspend fun getProductsList(@Query("categoryId") categoryId: String,
                                @Query("limit") limit: String): Products

}