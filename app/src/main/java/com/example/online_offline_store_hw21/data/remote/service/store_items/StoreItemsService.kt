package com.example.online_offline_store_hw21.data.remote.service.store_items

import com.example.online_offline_store_hw21.data.remote.model.StoreItemDto
import retrofit2.Response
import retrofit2.http.GET

interface StoreItemsService {
    @GET("df8d4951-2757-45aa-8f60-bf1592a090ce")
    suspend fun getStoreItems(): Response<List<StoreItemDto>>
}