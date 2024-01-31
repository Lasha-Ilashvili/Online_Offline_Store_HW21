package com.example.online_offline_store_hw21.domain.repository

import com.example.online_offline_store_hw21.data.common.Resource
import com.example.online_offline_store_hw21.domain.model.StoreItem
import kotlinx.coroutines.flow.Flow

interface StoreItemsRepository {
    suspend fun getStoreItems(): Flow<Resource<List<StoreItem>>>
}