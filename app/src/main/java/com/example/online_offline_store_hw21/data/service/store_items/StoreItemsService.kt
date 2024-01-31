package com.example.online_offline_store_hw21.data.service.store_items

import com.example.online_offline_store_hw21.data.model.StoreItemDto
import retrofit2.Response
import retrofit2.http.GET

interface StoreItemsService {
    @GET("1775d634-92dc-4c32-ae71-1707b8cfee41")
    suspend fun getStoreItems(): Response<List<StoreItemDto>>
}