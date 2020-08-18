package com.chibbis.base_feature.ui.recycler

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.chibbis.base.mappers.nonNull

/**
 * Horizontal divider
 */
class HorizontalDividerDecoration(
    context: Context,
    private val drawLast: Boolean = false,
    @DimenRes private val marginStart: Int? = null,
    @DimenRes private val marginEnd: Int? = null
) : RecyclerView.ItemDecoration() {

    private var divider: Drawable

    constructor(context: Context, resId: Int) : this(context) {
        divider = ContextCompat.getDrawable(context, resId) ?: error("Drawable not found")
    }

    init {
        val styledAttributes = context.obtainStyledAttributes(ATTRS)
        divider = styledAttributes.getDrawable(0) ?: error("Drawable not found")
        styledAttributes.recycle()
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val resources = parent.context.resources
        val left =
            parent.paddingLeft + marginStart?.let { resources.getDimensionPixelOffset(it) }.nonNull
        val right =
            parent.width - parent.paddingRight - marginEnd?.let {
                resources.getDimensionPixelOffset(it)
            }.nonNull
        val childCount = with(parent.childCount) {
            if (drawLast) {
                this
            } else {
                this - 1
            }
        }

        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + divider.intrinsicHeight
            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }

    companion object {
        private val ATTRS = intArrayOf(android.R.attr.listDivider)
    }
}