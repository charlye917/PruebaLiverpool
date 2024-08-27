package com.charlye934.shoppinliverpool.home.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.charlye934.shoppinliverpool.databinding.ItemProductInfoBinding
import com.charlye934.shoppinliverpool.home.domain.model.ColorsDataUI
import com.charlye934.shoppinliverpool.home.domain.model.ProductCardUI
import com.charlye934.shoppinliverpool.util.formatDiscountPrice
import com.charlye934.shoppinliverpool.util.formatRealPrice
import com.charlye934.shoppinliverpool.util.loadImage

class ProductsListAdapter(): ListAdapter<ProductCardUI, ProductsListAdapter.ViewHolder>(ProductsCallBack) {

    private lateinit var colorsAdapter: ColorsLIstAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        ItemProductInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemProductInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ProductCardUI) {
            binding.imgEvent.loadImage(data.imageProduct)
            binding.txtName.text = data.nameProduct
            binding.txtOriginalPrice.text = data.realPrice.toDouble().formatRealPrice()
            binding.txtDiscount.text = data.promoPrice.toDouble().formatDiscountPrice()
            binding.txtOriginalPrice.visibility = if(data.showRealPrice) View.VISIBLE else View.GONE
            binding.rvColors.apply {
                colorsAdapter = ColorsLIstAdapter(data.colors)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = colorsAdapter

            }
        }
    }

    private object ProductsCallBack: DiffUtil.ItemCallback<ProductCardUI>(){
        override fun areItemsTheSame(
            oldItem: ProductCardUI,
            newItem: ProductCardUI
        ) = oldItem.productId == newItem.productId

        override fun areContentsTheSame(
            oldItem: ProductCardUI,
            newItem: ProductCardUI
        ) = oldItem == newItem
    }
}