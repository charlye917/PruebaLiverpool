package com.charlye934.shoppinliverpool.home.domain.usecae

import com.charlye934.shoppinliverpool.home.data.repository.HomeRepository
import com.charlye934.shoppinliverpool.home.domain.mapper.responseDataAsProductUI
import com.charlye934.shoppinliverpool.home.domain.model.ProductCardUI
import com.charlye934.shoppinliverpool.network.BaseError
import com.charlye934.shoppinliverpool.network.Resources
import com.charlye934.shoppinliverpool.util.TypeSortPrice
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductInfoUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(
        search: String?,
        page: Int?,
        typeSortPrice: TypeSortPrice
    ) : Flow<Resources<List<ProductCardUI>>> = flow {
        homeRepository.getShoppingInfo(search, page, typeSortPrice)
            .catch { e -> e.printStackTrace() }
            .collect{ state ->
                when(state) {
                    is Resources.Loading -> {
                        emit(Resources.Loading)
                    }

                    is Resources.Success -> {
                        emit(Resources.Success(data = responseDataAsProductUI(state.data)))
                    }

                    else -> {
                        val error = state as Resources.Error
                        emit(Resources.Error(BaseError(message = error.error.message)))
                    }
                }
            }
    }
}