package com.charlye934.shoppinliverpool.home.data.model.response

import com.google.gson.annotations.SerializedName

data class VariantsColorResponse(
    val colorName: String,
    val colorHex: String,
    val colorImageURL: String?,
    val colorMainURL: String?,
    @SerializedName("skuId")
    val skuID: String?
)
