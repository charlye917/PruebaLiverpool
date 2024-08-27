package com.charlye934.shoppinliverpool.home.presenter.viewmodel.dataproducts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.charlye934.shoppinliverpool.home.domain.model.ProductCardUI
import com.charlye934.shoppinliverpool.home.domain.usecae.GetProductInfoUseCase
import com.charlye934.shoppinliverpool.network.Resources
import com.charlye934.shoppinliverpool.util.TypeSortPrice
import javax.inject.Inject

class DataProductsViewModelDelegateImp @Inject constructor(
    private val getProductInfoUseCase: GetProductInfoUseCase
): DataProductsViewModelDelegate {

    private val _isErrorData = MutableLiveData(false)
    override val isErrorData: LiveData<Boolean> get() = _isErrorData

    private val _loading = MutableLiveData(false)
    override val loading: LiveData<Boolean> get() = _loading

    private val _numPage = MutableLiveData(1)
    override val numPage: LiveData<Int> get() = _numPage

    private val _listDataProducts = MutableLiveData<List<ProductCardUI>>(listOf())
    override val listDataProducts: LiveData<List<ProductCardUI>> get() = _listDataProducts

    private val _allData = arrayListOf<ProductCardUI>()

    override suspend fun getListProductsDelegate(
        search: String?,
        page: Int?,
        typeSort: TypeSortPrice,
        clearData: Boolean
    ) {
        _isErrorData.postValue(false)
        _loading.postValue(true)
        _listDataProducts.postValue(listOf())

        getProductInfoUseCase.invoke(
            search, page, typeSort
        ).collect{
            when(it){
                is Resources.Loading -> {
                    _loading.postValue(true)
                }

                is Resources.Success -> {
                    if(clearData)
                        _allData.clear()
                    _allData.addAll(it.data)
                    _loading.postValue(false)
                    _isErrorData.postValue(false)
                    _listDataProducts.postValue(_allData)
                }

                is Resources.Error -> {
                    _loading.postValue(false)
                    _isErrorData.postValue(false)
                }
            }
        }
    }

    override suspend fun updateCounter(needUpdate: Boolean) {
        _numPage.value = if(needUpdate) _numPage.value?.plus(1) else 0
    }
}