package com.charlye934.shoppinliverpool.home.data.model.response

import com.google.gson.annotations.SerializedName

data class RecordResponse(
    @SerializedName("productId")
    val productID: String?,

    @SerializedName("skuRepositoryId")
    val skuRepositoryID: String?,

    val productDisplayName: String?,
    val productType: String?,
    val productRatingCount: Long?,
    val productAvgRating: Double?,
    val promotionalGiftMessage: String?,
    val listPrice: Double?,
    val minimumListPrice: Double?,
    val maximumListPrice: Double?,
    val promoPrice: Double?,
    val minimumPromoPrice: Double?,
    val maximumPromoPrice: Double?,
    val isHybrid: Boolean?,
    val isMarketPlace: Boolean?,
    val isImportationProduct: Boolean?,
    val brand: String?,
    val ar: Boolean?,
    val seller: String?,
    val category: String?,
    val dwPromotionInfo: DWPromotionInfoResponse?,
    val categoryBreadCrumbs: List<String?>,
    val smImage: String?,
    val lgImage: String?,
    val xlImage: String?,
    val groupType: String?,
    val plpFlags: List<Any?>,
    val variantsColor: List<VariantsColorResponse>? = null,
    val enableTryOn: Boolean?
)