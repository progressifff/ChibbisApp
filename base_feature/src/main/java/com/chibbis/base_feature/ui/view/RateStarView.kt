package com.chibbis.base_feature.ui.view

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import com.chibbis.base_feature.R

/**
 * View для отображения звезды оценки чего-либо.
 */
internal class RateStarView(context: Context) : AppCompatImageView(context) {

    init {
        setBackgroundResource(R.drawable.drawable_rate_star)
        isActivated = false
    }
}