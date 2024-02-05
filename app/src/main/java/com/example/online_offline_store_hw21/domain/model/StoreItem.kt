package com.example.online_offline_store_hw21.domain.model


data class StoreItem(
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val favorite: Boolean,
    val category: String
)