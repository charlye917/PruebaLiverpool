package com.charlye934.shoppinliverpool.home.data.model.response

import com.google.gson.annotations.SerializedName

data class RefinementResponse(
    val count: Long,
    val label: String,
    @SerializedName("refinementId")
    val refinementID: String,
    val selected: Boolean,
    val type: String,
    val searchName: String? = null,
    val high: String? = null,
    val low: String? = null,
    val colorHex: String? = null
)
