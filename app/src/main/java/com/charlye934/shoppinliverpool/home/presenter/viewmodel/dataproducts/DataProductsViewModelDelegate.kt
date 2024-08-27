package com.charlye934.shoppinliverpool.home.presenter.viewmodel.dataproducts

import androidx.lifecycle.LiveData
import com.charlye934.shoppinliverpool.home.domain.model.ProductCardUI
import com.charlye934.shoppinliverpool.util.TypeSortPrice

interface DataProductsViewModelDelegate {
    val loading: LiveData<Boolean>
    val isErrorData: LiveData<Boolean>
    val numPage: LiveData<Int>
    val listDataProducts: LiveData<List<ProductCardUI>>

    suspend fun getListProductsDelegate(
        search: String?,
        page: Int?,
        typeSort: TypeSortPrice,
        clearData: Boolean = false
    )

    suspend fun updateCounter(needUpdate: Boolean = true)
}