package com.charlye934.shoppinliverpool.home.domain.model

data class ProductCardUI(
    val productId: String,
    val imageProduct: String,
    val nameProduct: String,
    val realPrice: String,
    val promoPrice: String,
    val colors: List<ColorsDataUI?>?,
    val showRealPrice: Boolean
)