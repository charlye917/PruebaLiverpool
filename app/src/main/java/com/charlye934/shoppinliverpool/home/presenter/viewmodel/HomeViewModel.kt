package com.charlye934.shoppinliverpool.home.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charlye934.shoppinliverpool.home.presenter.viewmodel.dataproducts.DataProductsViewModelDelegate
import com.charlye934.shoppinliverpool.util.TypeSortPrice
import com.charlye934.shoppinliverpool.util.TypeSortPrice.MIN_SORT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataProductsViewModelDelegate: DataProductsViewModelDelegate
) : ViewModel(),
    DataProductsViewModelDelegate by dataProductsViewModelDelegate {

    fun getDataProducts(
        page: Int?,
        search: String? = null,
        sortType: TypeSortPrice = MIN_SORT,
        clearData: Boolean = false
    ){
        viewModelScope.launch {
            getListProductsDelegate(
                search,
                page,
                sortType,
                clearData
            )
        }
    }

    fun updatePage(needUpdate: Boolean){
        viewModelScope.launch {
            updateCounter(needUpdate)
        }
    }
}