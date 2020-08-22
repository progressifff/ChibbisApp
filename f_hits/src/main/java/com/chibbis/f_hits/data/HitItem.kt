package com.chibbis.f_hits.data

import android.graphics.drawable.Drawable
import com.chibbis.domain.hit.Hit
import com.chibbis.f_hits.R
import com.chibbis.f_hits.databinding.ItemHitBinding
import com.xwray.groupie.databinding.BindableItem

/**
 * Элемент UI списка хитов продаж
 */
data class HitItem(
    private val hit: Hit,
    private val onHitImageLongClick: (Drawable) -> Unit
) : BindableItem<ItemHitBinding>() {
    override fun getLayout(): Int = R.layout.item_hit

    override fun getId(): Long = hit.id.hashCode().toLong()

    override fun bind(viewBinding: ItemHitBinding, position: Int) {
        viewBinding.hit = hit
        viewBinding.hitFoodIv.setOnLongClickListener {
            onHitImageLongClick(viewBinding.hitFoodIv.drawable)
            true
        }
    }
}