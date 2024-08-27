package com.charlye934.shoppinliverpool.home.data.model.response

data class DataShoppingResponse(
    val status: StatusResponse,
    val pageType: String,
    val plpResults: PlpResultsResponse
)

