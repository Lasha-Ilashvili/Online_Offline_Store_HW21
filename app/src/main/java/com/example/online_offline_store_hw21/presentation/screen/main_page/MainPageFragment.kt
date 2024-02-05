package com.example.online_offline_store_hw21.presentation.screen.main_page

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.online_offline_store_hw21.databinding.FragmentMainPageBinding
import com.example.online_offline_store_hw21.presentation.base.BaseFragment
import com.example.online_offline_store_hw21.presentation.event.StoreItemsEvent
import com.example.online_offline_store_hw21.presentation.state.store_items.StoreItemsState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainPageFragment : BaseFragment<FragmentMainPageBinding>(FragmentMainPageBinding::inflate) {

    private val viewModel: MainPageViewModel by viewModels()

    override fun setListeners() {
        binding.btnRefresh.setOnClickListener {
            viewModel.onEvent(StoreItemsEvent.Refresh)
        }
    }

    override fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.storeItems.collect {
                    handleState(it)
                }
            }
        }
    }

    private fun handleState(storeItemsState: StoreItemsState) = with(binding) {
        progressBar.visibility =
            if (storeItemsState.isLoading) View.VISIBLE else View.GONE

        storeItemsState.errorState?.let {
            tvErrorMessage.visibility = View.VISIBLE
            btnRefresh.visibility = View.VISIBLE
            viewModel.onEvent(StoreItemsEvent.ResetErrorState)
        }

        storeItemsState.data?.let {
            btnRefresh.visibility = View.GONE
            tvErrorMessage.visibility = View.GONE

            rvStoreItems.adapter = MainPageRecyclerAdapter().apply {
                setData(it)
            }

            val categorySet = mutableSetOf<String>()
            for (item in it) {
                categorySet.add(item.category)
            }

            rvCategory.adapter = MainPageCategoryRecyclerAdapter().apply {
                setData(categorySet.toList())
            }
        }
    }
}