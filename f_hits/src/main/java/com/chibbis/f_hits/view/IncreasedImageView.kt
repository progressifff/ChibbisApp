package com.chibbis.f_hits.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.transition.Fade
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.chibbis.f_hits.R
import kotlinx.android.synthetic.main.view_increased_image.view.*

/**
 * Вью для показа увеличенного изображения
 */
class IncreasedImageView @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null
) : FrameLayout(context, attributes) {

    init {
        View.inflate(context, R.layout.view_increased_image, this)
    }

    fun render(image: Drawable?) {
        val transition: Transition = Fade()
        transition.duration =
            resources.getInteger(R.integer.increase_image_animation_duration_millis).toLong()
        transition.addTarget(this)
        TransitionManager.beginDelayedTransition(this.parent as ViewGroup, transition)
        increased_iv.setImageDrawable(image)
        this@IncreasedImageView.isVisible = image != null
    }
}