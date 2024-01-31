package com.example.online_offline_store_hw21.data.repository.store_items

import com.example.online_offline_store_hw21.data.common.HandleResponse
import com.example.online_offline_store_hw21.data.common.Resource
import com.example.online_offline_store_hw21.data.mapper.base.asResource
import com.example.online_offline_store_hw21.data.mapper.store_item.toDomain
import com.example.online_offline_store_hw21.data.service.store_items.StoreItemsService
import com.example.online_offline_store_hw21.domain.model.StoreItem
import com.example.online_offline_store_hw21.domain.repository.StoreItemsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StoreItemsRepositoryImpl @Inject constructor(
    private val storeItemsService: StoreItemsService,
    private val handleResponse: HandleResponse,
) : StoreItemsRepository {

    override suspend fun getStoreItems(): Flow<Resource<List<StoreItem>>> {
        return handleResponse.safeApiCall {
            storeItemsService.getStoreItems()
        }.asResource {
            it.map { dto ->
                dto.toDomain()
            }
        }
    }
}
