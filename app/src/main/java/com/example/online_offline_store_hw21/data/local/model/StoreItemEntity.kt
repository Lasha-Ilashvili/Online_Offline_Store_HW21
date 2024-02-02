package com.example.online_offline_store_hw21.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class StoreItemEntity(
    @PrimaryKey
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val favorite: Boolean
)