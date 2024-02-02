package com.example.online_offline_store_hw21.presentation.event

sealed class StoreItemsEvent {
    data object Refresh : StoreItemsEvent()
    data object ResetSuccessState : StoreItemsEvent()
    data object ResetErrorState : StoreItemsEvent()
}