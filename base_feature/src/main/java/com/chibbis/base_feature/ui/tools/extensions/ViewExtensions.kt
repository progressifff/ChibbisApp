package com.chibbis.base_feature.ui.tools.extensions

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children

/**
 * Поиск всех [View] с заданным тегом.
 */
fun View.findViewsByTag(tag: String): List<View> {
    val views = ArrayList<View>()
    if (this.tag == tag) {
        views.add(this)
    }
    if (this is ViewGroup) {
        children.forEach { child ->
            if (child is ViewGroup) {
                views.addAll(child.findViewsByTag(tag))
            }
            if (child.tag == tag) {
                views.add(child)
            }
        }
    }
    return views
}

/**
 * Установка отступа справа от View.
 *
 * @param rightMarginPx величина отступа в px.
 */
fun View.setRightMargin(rightMarginPx: Int) {
    val params = layoutParams as? ViewGroup.MarginLayoutParams
    params?.rightMargin = rightMarginPx
}