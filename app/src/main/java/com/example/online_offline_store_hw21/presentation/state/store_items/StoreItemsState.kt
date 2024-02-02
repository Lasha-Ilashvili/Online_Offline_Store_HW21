package com.example.online_offline_store_hw21.presentation.state.store_items

import com.example.online_offline_store_hw21.domain.model.StoreItem


data class StoreItemsState(
    val isLoading: Boolean = true,
    val data: List<StoreItem>? = null,
    val errorState: Boolean? = null
)