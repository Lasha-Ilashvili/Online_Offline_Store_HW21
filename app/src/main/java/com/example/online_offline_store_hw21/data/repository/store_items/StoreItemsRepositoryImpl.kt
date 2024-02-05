package com.example.online_offline_store_hw21.data.repository.store_items

import com.example.online_offline_store_hw21.data.common.Resource
import com.example.online_offline_store_hw21.data.local.dao.ItemDao
import com.example.online_offline_store_hw21.data.mapper.toDomain
import com.example.online_offline_store_hw21.data.mapper.toEntity
import com.example.online_offline_store_hw21.data.remote.data_source.StoreItemDataSource
import com.example.online_offline_store_hw21.data.remote.model.StoreItemDto
import com.example.online_offline_store_hw21.domain.model.StoreItem
import com.example.online_offline_store_hw21.domain.repository.StoreItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StoreItemsRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
    private val storeItemDataSource: StoreItemDataSource,
//    private val connectivityManager: ConnectivityManager
) : StoreItemsRepository {

    override fun getStoreItems(): Flow<Resource<List<StoreItem>>> {
        return flow {

//            connectivityManager.


            

            emit(Resource.Loading(loading = true))

            val remoteItemsResponse = storeItemDataSource()

            if (remoteItemsResponse is Resource.Success) {
                writeToDao(remoteItemsResponse.data)
            }

            val localItems = itemDao.getItems()

            if (localItems.isEmpty()) {
                emit(Resource.Loading(loading = false))
                emit(Resource.Error)
            } else {
                emit(Resource.Loading(loading = false))
                emit(Resource.Success(localItems.map { it.toDomain() }))
            }

        }.flowOn(Dispatchers.IO)
    }

    private suspend fun writeToDao(remoteItemsResponse: List<StoreItemDto>) {
        withContext(Dispatchers.Default) {
            itemDao.insertItems(remoteItemsResponse.map {
                it.toEntity()
            })
        }
    }
}