package com.example.online_offline_store_hw21.presentation.screen.main_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.online_offline_store_hw21.R
import com.example.online_offline_store_hw21.databinding.StoreCategoryBinding

class MainPageCategoryRecyclerAdapter :
    RecyclerView.Adapter<MainPageCategoryRecyclerAdapter.MainPageCategoryViewHolder>() {

    private lateinit var categoryList: List<String>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPageCategoryViewHolder {
        return MainPageCategoryViewHolder(
            StoreCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainPageCategoryViewHolder, position: Int) {
        holder.bind()
    }

    fun setData(newList: List<String>) {
        categoryList = newList
    }

    override fun getItemCount(): Int = categoryList.size


    inner class MainPageCategoryViewHolder(private val binding: StoreCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            with(binding) {
                tvCategory.text = categoryList[adapterPosition]
//                    ivStoreItem.loadImage(storeItem.cover)
//                    setFavorite(ibFavorite, storeItem.favorite)
//                    tvTitle.text = storeItem.title
//                    tvPrice.text = storeItem.price
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