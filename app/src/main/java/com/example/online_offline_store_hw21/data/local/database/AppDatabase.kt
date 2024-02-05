package com.example.online_offline_store_hw21.data.local.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.online_offline_store_hw21.data.local.dao.ItemDao
import com.example.online_offline_store_hw21.data.local.model.StoreItemEntity

@Database(
    entities = [StoreItemEntity::class],
    version = 2,
    autoMigrations = [AutoMigration(from = 1, to = 2)],
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}