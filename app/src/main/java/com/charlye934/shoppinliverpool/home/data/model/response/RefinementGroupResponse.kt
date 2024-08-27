package com.charlye934.shoppinliverpool.home.data.model.response

data class RefinementGroupResponse(
    val name: String,
    val refinement: List<RefinementResponse>,
    val multiSelect: Boolean,
    val dimensionName: String,
    val moreRefinements: Boolean
)
