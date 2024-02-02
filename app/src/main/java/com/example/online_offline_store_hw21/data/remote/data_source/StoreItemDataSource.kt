package com.example.online_offline_store_hw21.data.remote.data_source

import com.example.online_offline_store_hw21.data.common.HandleResponse
import com.example.online_offline_store_hw21.data.common.Resource
import com.example.online_offline_store_hw21.data.remote.model.StoreItemDto
import com.example.online_offline_store_hw21.data.remote.service.store_items.StoreItemsService
import javax.inject.Inject

class StoreItemDataSource @Inject constructor(
    private val storeItemsService: StoreItemsService,
    private val handleResponse: HandleResponse
){

    suspend operator fun invoke(): Resource<List<StoreItemDto>> {
        return handleResponse.safeApiCall {
            storeItemsService.getStoreItems()
        }
    }
}