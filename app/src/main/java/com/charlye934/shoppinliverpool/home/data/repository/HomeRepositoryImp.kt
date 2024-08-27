package com.charlye934.shoppinliverpool.home.data.repository

import android.content.Context
import com.charlye934.shoppinliverpool.R
import com.charlye934.shoppinliverpool.home.data.model.response.DataShoppingResponse
import com.charlye934.shoppinliverpool.home.data.service.HomeService
import com.charlye934.shoppinliverpool.network.BaseError
import com.charlye934.shoppinliverpool.network.Resources
import com.charlye934.shoppinliverpool.util.ConstantsServices
import com.charlye934.shoppinliverpool.util.ConstantsServices.CODE_SUCCESSFUL
import com.charlye934.shoppinliverpool.util.TypeSortPrice
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import java.lang.reflect.Type
import javax.inject.Inject

class HomeRepositoryImp @Inject constructor(
    private val service: HomeService,
    @ApplicationContext private val context: Context
) : HomeRepository{

    override fun getShoppingInfo(
        search: String?,
        page: Int?,
        typeSort: TypeSortPrice
    ): Flow<Resources<DataShoppingResponse>> = flow {
        emit(Resources.Loading)
        try {
            val response = service.getProducctsShopping(search, page, TypeSortPrice.getTypeSortPrice(typeSort))
            if(response.isSuccessful) {
                response.body()?.let {
                    if(it.status.statusCode == CODE_SUCCESSFUL ){
                        emit(Resources.Success(data = it))
                    } else {
                        emit(Resources.Error(BaseError(message = context.getString(R.string.generic_subtitle_error))))
                    }
                }
            } else
                emit(Resources.Error(BaseError(message = context.getString(R.string.generic_subtitle_error))))
        } catch (e: Exception) {
            emit(Resources.Error(BaseError(message = context.getString(R.string.generic_subtitle_error))))
        }
    }
}