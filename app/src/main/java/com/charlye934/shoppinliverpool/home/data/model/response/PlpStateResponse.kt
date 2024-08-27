package com.charlye934.shoppinliverpool.home.data.model.response

import com.google.gson.annotations.SerializedName

data class PlpStateResponse(
    @SerializedName("categoryId")
    val categoryID: String,
    val currentSortOption: String,
    val currentFilters: String,
    val firstRecNum: Long,
    val lastRecNum: Long,
    val recsPerPage: Long,
    val totalNumRecs: Long,
    val originalSearchTerm: String,
    val plpSellerName: String,
    val area: String,
    val id: String
)