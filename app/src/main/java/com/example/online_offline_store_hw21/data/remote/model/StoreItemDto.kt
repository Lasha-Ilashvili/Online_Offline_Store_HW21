package com.example.online_offline_store_hw21.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StoreItemDto(
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val favorite: Boolean
)