package com.example.online_offline_store_hw21.data.mapper

import com.example.online_offline_store_hw21.data.local.model.StoreItemEntity
import com.example.online_offline_store_hw21.data.remote.model.StoreItemDto
import com.example.online_offline_store_hw21.domain.model.StoreItem


fun StoreItemDto.toEntity() = StoreItemEntity(
    id = id,
    cover = cover,
    price = price,
    title = title,
    favorite = favorite
)

fun StoreItemEntity.toDomain() = StoreItem(
    id = id,
    cover = cover,
    price = price,
    title = title,
    favorite = favorite
)