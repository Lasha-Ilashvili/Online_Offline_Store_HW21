package com.example.online_offline_store_hw21.di

import com.example.online_offline_store_hw21.data.common.HandleResponse
import com.example.online_offline_store_hw21.data.repository.store_items.StoreItemsRepositoryImpl
import com.example.online_offline_store_hw21.data.service.store_items.StoreItemsService
import com.example.online_offline_store_hw21.domain.repository.StoreItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideStoreItemsRepository(
        storeItemsService: StoreItemsService,
        handleResponse: HandleResponse
    ): StoreItemsRepository {
        return StoreItemsRepositoryImpl(
            storeItemsService = storeItemsService,
            handleResponse = handleResponse
        )
    }
}