package com.chibbis.base_feature.ui.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.cardview.widget.CardView
import com.chibbis.base_feature.R

/**
 * Заглушка шиммер
 */
class ShimmerStubView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : CardView(context, attrs) {

    var isLoading: Boolean
        set(value) {
            shimmerView.isLoading = value
        }
        get() = shimmerView.isLoading

    private var isCircle: Boolean = false
    private lateinit var shimmerView: AppShimmer

    init {
        obtainAttrs(attrs)
        initView()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (isCircle) {
            radius = w / 2.0f
        }
    }

    private fun addStubView() {
        shimmerView = AppShimmer(context).apply {
            layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
            addView(
                View(context).apply {
                    layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
                    background = this@ShimmerStubView.background
                }
            )
        }
        addView(shimmerView)
    }

    private fun setTag() {
        if (tag == null) {
            tag = context.getString(R.string.shimmer_stub_view_tag)
        }
    }

    private fun obtainAttrs(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShimmerStubView)

        isCircle = typedArray.getBoolean(R.styleable.ShimmerStubView_isCircle, false)
        radius = typedArray.getDimensionPixelOffset(R.styleable.ShimmerStubView_cornerRadius, 0)
            .toFloat()
        setBackgroundColor(
            typedArray.getColor(
                R.styleable.ShimmerStubView_stubColor,
                Color.TRANSPARENT
            )
        )

        typedArray.recycle()
    }

    private fun initView() {
        addStubView()
        setTag()
    }
}