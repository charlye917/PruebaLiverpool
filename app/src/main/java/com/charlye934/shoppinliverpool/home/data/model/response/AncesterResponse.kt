package com.charlye934.shoppinliverpool.home.data.model.response

import com.google.gson.annotations.SerializedName

data class AncesterResponse(
    val label: String,

    @SerializedName("categoryId")
    val categoryID: String
)