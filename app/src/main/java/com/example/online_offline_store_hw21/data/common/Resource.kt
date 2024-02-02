package com.example.online_offline_store_hw21.data.common

sealed class Resource<out D : Any> {
    data class Success<out D : Any>(val data: D) : Resource<D>()
    data object Error : Resource<Nothing>()
    data class Loading(val loading: Boolean) : Resource<Nothing>()
}
