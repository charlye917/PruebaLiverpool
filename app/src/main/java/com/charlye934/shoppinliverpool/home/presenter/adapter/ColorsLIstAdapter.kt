package com.charlye934.shoppinliverpool.home.presenter.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.charlye934.shoppinliverpool.databinding.ItemColorBinding
import com.charlye934.shoppinliverpool.databinding.ItemProductInfoBinding
import com.charlye934.shoppinliverpool.home.domain.model.ColorsDataUI
import com.charlye934.shoppinliverpool.home.domain.model.ProductCardUI

class ColorsLIstAdapter(private val colors: List<ColorsDataUI?>?):
    RecyclerView.Adapter<ColorsLIstAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemColorBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: ColorsDataUI?){
            if(!data?.colorHex.isNullOrEmpty())
                binding.circleColor.setColorFilter(Color.parseColor(data?.colorHex))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  ViewHolder(
        ItemColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = colors?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(colors?.get(position))
    }
}