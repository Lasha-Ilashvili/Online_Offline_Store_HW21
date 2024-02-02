package com.example.online_offline_store_hw21.presentation.screen.main_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.online_offline_store_hw21.data.common.Resource
import com.example.online_offline_store_hw21.domain.usecase.store_items.GetStoreItemsUseCase
import com.example.online_offline_store_hw21.presentation.event.StoreItemsEvent
import com.example.online_offline_store_hw21.presentation.state.store_items.StoreItemsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(
    private val storeItemsUseCase: GetStoreItemsUseCase
) : ViewModel() {

    private val _storeItems = MutableStateFlow(StoreItemsState())
    val storeItems get() = _storeItems.asStateFlow()


    init {
        setList()
    }

    fun onEvent(event: StoreItemsEvent) {
        when (event) {
            StoreItemsEvent.ResetErrorState -> resetErrorMessage()
            StoreItemsEvent.Refresh -> setList()
            StoreItemsEvent.ResetSuccessState -> resetSuccessState()
        }
    }

    private fun setList() {
        viewModelScope.launch {
            storeItemsUseCase().collect {
                when (it) {
                    is Resource.Success -> {
                        _storeItems.update { currentState ->
                            currentState.copy(data = it.data)
                        }
                    }

                    is Resource.Error -> {
                        _storeItems.update { currentState ->
                            currentState.copy(errorState = true)
                        }
                    }

                    is Resource.Loading -> {
                        _storeItems.update { currentState ->
                            currentState.copy(isLoading = it.loading)
                        }
                    }
                }
            }
        }
    }

    private fun resetSuccessState() {
        _storeItems.update { currentState ->
            currentState.copy(data = null)
        }
    }

    private fun resetErrorMessage() {
        _storeItems.update { currentState ->
            currentState.copy(errorState = null)
        }
    }
}