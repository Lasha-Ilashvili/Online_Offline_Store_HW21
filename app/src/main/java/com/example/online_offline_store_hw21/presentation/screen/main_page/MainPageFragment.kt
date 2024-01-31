package com.example.online_offline_store_hw21.presentation.screen.main_page

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.online_offline_store_hw21.databinding.FragmentMainPageBinding
import com.example.online_offline_store_hw21.presentation.base.BaseFragment
import com.example.online_offline_store_hw21.presentation.state.store_items.StoreItemsState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainPageFragment : BaseFragment<FragmentMainPageBinding>(FragmentMainPageBinding::inflate) {

    private val viewModel: MainPageViewModel by viewModels()

    override fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.storeItems.collect {
                    handleState(it)
                }
            }
        }
    }

    private fun handleState(storeItemsState: StoreItemsState) {
        binding.progressBar.visibility =
            if (storeItemsState.isLoading) View.VISIBLE else View.GONE

        storeItemsState.data?.let {
            binding.rvParent.adapter = MainPageRecyclerAdapter().apply {
                setData(it)
            }
        }

//        storeItemsState.errorMessage?.let {
//            binding.root.showToast(storeItemsState.errorMessage)
//            viewModel.onEvent(StoreItemsEvent.ResetErrorMessage)
//        }
    }
}