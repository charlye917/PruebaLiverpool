package com.charlye934.shoppinliverpool.home.data.service

import com.charlye934.shoppinliverpool.home.data.model.response.DataShoppingResponse
import com.charlye934.shoppinliverpool.util.ConstantsServices.SERVICE_GET_PRODUCTS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface HomeService {

    @GET(SERVICE_GET_PRODUCTS)
    suspend fun getProducctsShopping(
        @Query("search-string") search: String?,
        @Query("page-number") page: Int?,
        @Query("minSortPrice") minSortPrice: Int?
    ): Response<DataShoppingResponse>
}