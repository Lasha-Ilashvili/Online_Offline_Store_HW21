package com.example.online_offline_store_hw21.presentation.screen.main_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.online_offline_store_hw21.R
import com.example.online_offline_store_hw21.databinding.StoreItemBinding
import com.example.online_offline_store_hw21.domain.model.StoreItem
import com.example.online_offline_store_hw21.presentation.extension.loadImage

class MainPageRecyclerAdapter :
    RecyclerView.Adapter<MainPageRecyclerAdapter.MainPageItemViewHolder>() {

    private lateinit var storeItemList: List<StoreItem>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPageItemViewHolder {
        return MainPageItemViewHolder(
            StoreItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainPageItemViewHolder, position: Int) {
        holder.bind()
    }

    fun setData(newList: List<StoreItem>) {
        storeItemList = newList
    }

    override fun getItemCount(): Int = storeItemList.size


    inner class MainPageItemViewHolder(private val binding: StoreItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val storeItem = storeItemList[adapterPosition]

            with(binding) {
                ivStoreItem.loadImage(storeItem.cover)
                setFavorite(ibFavorite, storeItem.favorite)
                tvTitle.text = storeItem.title
                tvPrice.text = storeItem.price
            }
        }

        private fun setFavorite(ibFavorite: AppCompatImageButton, isFavorite: Boolean) {
            ibFavorite.setImageResource(
                if (isFavorite)
                    R.drawable.ic_heart__filled
                else
                    R.drawable.ic_heart_unfilled
            )
        }
    }
}