package com.example.online_offline_store_hw21.domain.usecase.store_items

import com.example.online_offline_store_hw21.domain.repository.StoreItemsRepository
import javax.inject.Inject

class GetStoreItemsUseCase @Inject constructor(
    private val storeItemsRepository: StoreItemsRepository
) {
    suspend operator fun invoke() =
        storeItemsRepository.getStoreItems()
}