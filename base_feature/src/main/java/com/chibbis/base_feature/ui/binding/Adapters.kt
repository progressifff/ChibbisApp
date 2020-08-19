package com.chibbis.base_feature.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chibbis.base_feature.ui.tools.extensions.setGroups
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter

@BindingAdapter("app:items")
fun installItems(view: RecyclerView, groups: List<Group>?) {
    groups?.let { (view.adapter as? GroupAdapter)?.setGroups(it) }
}

@BindingAdapter("app:goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}