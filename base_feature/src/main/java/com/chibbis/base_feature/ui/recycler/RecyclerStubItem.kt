package com.chibbis.base_feature.ui.recycler

import androidx.annotation.LayoutRes
import com.chibbis.base_feature.R
import com.chibbis.base_feature.ui.tools.extensions.findViewsByTag
import com.chibbis.base_feature.ui.view.AppShimmer
import com.chibbis.base_feature.ui.view.ShimmerStubView
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

data class RecyclerStubItem(
    @LayoutRes private val layoutRes: Int,
    private val isLoading: Boolean
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView
            .findViewsByTag(viewHolder.itemView.context.getString(R.string.shimmer_stub_view_tag))
            .filterIsInstance<ShimmerStubView>()
            .map { it.isLoading = isLoading }
    }

    override fun getLayout(): Int = layoutRes

}