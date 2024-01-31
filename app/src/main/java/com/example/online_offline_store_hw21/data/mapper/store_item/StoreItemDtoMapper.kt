package com.example.online_offline_store_hw21.data.mapper.store_item

import com.example.online_offline_store_hw21.data.model.StoreItemDto
import com.example.online_offline_store_hw21.domain.model.StoreItem

fun StoreItemDto.toDomain(): StoreItem {
    return StoreItem(
        id = id,
        cover = cover,
        price = price,
        title = title,
        favorite = favorite
    )
}