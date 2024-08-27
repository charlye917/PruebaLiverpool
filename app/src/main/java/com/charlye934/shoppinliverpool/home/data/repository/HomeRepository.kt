package com.charlye934.shoppinliverpool.home.data.repository

import com.charlye934.shoppinliverpool.home.data.model.response.DataShoppingResponse
import com.charlye934.shoppinliverpool.network.Resources
import com.charlye934.shoppinliverpool.util.TypeSortPrice
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getShoppingInfo(
        search: String?,
        page: Int?,
        typeSort: TypeSortPrice
    ): Flow<Resources<DataShoppingResponse>>
}