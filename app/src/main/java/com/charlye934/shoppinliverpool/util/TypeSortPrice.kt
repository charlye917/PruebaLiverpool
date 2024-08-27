package com.charlye934.shoppinliverpool.util

enum class TypeSortPrice {
    MIN_SORT,
    MAX_SORT;


    companion object {
        fun getTypeSortPrice(type: TypeSortPrice): Int {
            return when (type) {
                MIN_SORT -> 0
                MAX_SORT -> 1
            }
        }
    }
}