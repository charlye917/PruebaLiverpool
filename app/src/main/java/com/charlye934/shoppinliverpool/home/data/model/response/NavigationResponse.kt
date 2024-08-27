package com.charlye934.shoppinliverpool.home.data.model.response

data class NavigationResponse(
    val ancester: List<AncesterResponse>,
    val current: List<AncesterResponse>,
    val childs: List<Any?>
)