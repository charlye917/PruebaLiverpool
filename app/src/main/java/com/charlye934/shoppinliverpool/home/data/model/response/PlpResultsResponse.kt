package com.charlye934.shoppinliverpool.home.data.model.response

data class PlpResultsResponse(
    val label: String,
    val plpState: PlpStateResponse,
    val sortOptions: List<SortOptionResponse>,
    val refinementGroups: List<RefinementGroupResponse>,
    val records: List<RecordResponse>,
    val navigation: NavigationResponse,
    val metaData: MetaDataResponse,
    val redirectTo404: Boolean,
    val enableMinNumOfPieces: Boolean
)