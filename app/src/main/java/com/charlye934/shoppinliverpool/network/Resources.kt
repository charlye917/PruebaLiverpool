package com.charlye934.shoppinliverpool.network

sealed class Resources <out T>{
    data class Success<out T: Any>(val data: T): Resources<T>()
    object Loading: Resources<Nothing>()
    data class Error(val error: BaseError): Resources<Nothing>()
}