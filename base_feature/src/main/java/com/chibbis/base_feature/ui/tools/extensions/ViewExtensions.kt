package com.chibbis.base_feature.ui.tools.extensions

import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.children
import androidx.core.widget.NestedScrollView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val DEFAULT_ELEVATION_ON = 8f
private const val DEFAULT_ELEVATION_OFF = 0f
const val EMPTY_RESOURCE = 0

/**
 * Приподнимает [View] если произошел скролл [RecyclerView]
 */
fun View.attachToRecyclerView(recyclerView: RecyclerView) {
    recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val elevation =
                if (dy <= 0 && (recyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition() == 0)
                    DEFAULT_ELEVATION_OFF
                else
                    DEFAULT_ELEVATION_ON
            ViewCompat.setElevation(this@attachToRecyclerView, elevation)
        }
    })
}

/**
 * Приподнимает [View] если произошел скролл [NestedScrollView]
 */
fun View.attachToNestedScrollView(scrollView: NestedScrollView) {
    scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
        val elevation =
            if (scrollY == 0) DEFAULT_ELEVATION_OFF else DEFAULT_ELEVATION_ON
        ViewCompat.setElevation(this@attachToNestedScrollView, elevation)
    })
}

inline fun <reified T : ViewGroup> View.findAncestor(): T? {
    var p = parent
    while (p != null) {
        if (p is T) {
            return p
        }
        p = p.parent
    }
    return null
}

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