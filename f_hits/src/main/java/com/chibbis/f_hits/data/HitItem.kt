package com.chibbis.f_hits.data

import com.chibbis.domain.hit.Hit
import com.chibbis.f_hits.R
import com.chibbis.f_hits.databinding.ItemHitBinding
import com.xwray.groupie.databinding.BindableItem

/**
 * Элемент UI списка хитов продаж
 */
class HitItem(private val hit: Hit) : BindableItem<ItemHitBinding>() {
    override fun getLayout(): Int = R.layout.item_hit

    override fun getId(): Long = hit.id.hashCode().toLong()

    override fun bind(viewBinding: ItemHitBinding, position: Int) {
        viewBinding.hit = hit
    }
}