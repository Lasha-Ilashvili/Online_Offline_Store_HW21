package com.example.online_offline_store_hw21.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.online_offline_store_hw21.data.local.model.StoreItemEntity

@Dao
interface ItemDao {

    @Query("SELECT * FROM StoreItemEntity")
    suspend fun getItems(): List<StoreItemEntity>

    @Upsert
    suspend fun insertItems(items: List<StoreItemEntity>)
}