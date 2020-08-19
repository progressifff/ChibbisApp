package com.chibbis.base_feature.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import androidx.annotation.CallSuper
import com.chibbis.base_feature.R
import io.supercharge.shimmerlayout.ShimmerLayout

open class AppShimmer @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyle: Int = R.style.AppShimmer
) : ShimmerLayout(ContextThemeWrapper(context, R.style.AppShimmer), attrs, defStyle) {

    var isLoading: Boolean = false
        set(value) {
            field = value
            if (value) super.startShimmerAnimation() else super.stopShimmerAnimation()
        }

    @CallSuper
    override fun startShimmerAnimation() {
        isLoading = true
    }

    @CallSuper
    override fun stopShimmerAnimation() {
        isLoading = false
    }
}