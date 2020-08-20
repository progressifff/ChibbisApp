package com.chibbis.base_feature.ui.binding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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

@BindingAdapter("app:url", "app:errorImage")
fun loadImage(view: ImageView, url: String?, errorImage: Drawable?) {
    if (url != null && errorImage != null) {
        Glide.with(view.context).load(url).error(errorImage).into(view)
    }
}