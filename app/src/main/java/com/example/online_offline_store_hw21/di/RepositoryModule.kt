package com.example.online_offline_store_hw21.di

import com.example.online_offline_store_hw21.data.local.dao.ItemDao
import com.example.online_offline_store_hw21.data.remote.data_source.StoreItemDataSource
import com.example.online_offline_store_hw21.data.repository.store_items.StoreItemsRepositoryImpl
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
        itemDao: ItemDao,
        storeItemDataSource: StoreItemDataSource
    ): StoreItemsRepository {
        return StoreItemsRepositoryImpl(
            itemDao = itemDao,
            storeItemDataSource = storeItemDataSource
        )
    }
}