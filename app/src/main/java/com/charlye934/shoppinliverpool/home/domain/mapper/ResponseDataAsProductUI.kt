package com.charlye934.shoppinliverpool.home.domain.mapper

import com.charlye934.shoppinliverpool.home.data.model.response.DataShoppingResponse
import com.charlye934.shoppinliverpool.home.domain.model.ColorsDataUI
import com.charlye934.shoppinliverpool.home.domain.model.ProductCardUI

fun responseDataAsProductUI(dataShopping: DataShoppingResponse): List<ProductCardUI> =
    dataShopping.plpResults.records.map {
        ProductCardUI(
            productId = it.productID ?: "",
            imageProduct = it.smImage ?: "",
            nameProduct = it.productDisplayName ?: "",
            realPrice = it.listPrice.toString(),
            promoPrice = it.promoPrice.toString(),
            showRealPrice = it.listPrice != it.promoPrice,
            colors = it.variantsColor?.map { color ->
                ColorsDataUI(
                    colorHex = color.colorHex,
                )
            } ?: listOf()
        )
    }