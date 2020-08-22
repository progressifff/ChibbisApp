package com.chibbis.base_feature.ui.recycler

import android.widget.TextView
import androidx.annotation.StringRes
import com.chibbis.base_feature.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

data class RecyclerTextItem(@StringRes private val stringRes: Int) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        (viewHolder.itemView as TextView).apply {
            text = context.getString(stringRes)
        }
    }

    override fun getLayout(): Int = R.layout.item_text
}