package com.chibbis.base_feature.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.updateLayoutParams
import com.chibbis.base_feature.R
import com.chibbis.base_feature.ui.tools.extensions.setRightMargin
import java.util.*
import kotlin.math.min

/**
 * [View] для выбора оценки чего-либо.
 */
class RateView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var onRateChangedAction: ((currentChosenStarCount: Int) -> Unit)? = null

    private val starViewMap = TreeMap<Int, RateStarView>()
    private val maxStarSize = context.resources.getDimensionPixelSize(R.dimen.max_star_view_size)

    private var starSpacing = 0
    private var starCount = DEFAULT_RATE_STAR_COUNT

    private var currentLastChosenStarIndex: Int? = null

    private val motionsToDetectSet = setOf(MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE)

    init {
        obtainAttributes(attrs)
        initView()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val possibleStarViewSize = getPossibleStarViewSize(w)
        val starSize = min(possibleStarViewSize, maxStarSize)
        updateStarViewsSize(starSize)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initView() {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_HORIZONTAL
        createStarViews()
        setOnTouchListener { _, event -> handleViewTouch(event) }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun createStarViews() {
        repeat(starCount) { starIndex ->
            val isLastStar = starIndex == starCount - 1
            val rateStarView = RateStarView(context)
            addView(rateStarView)
            if (!isLastStar) {
                rateStarView.setRightMargin(starSpacing)
            }
            rateStarView.setOnTouchListener { v, _ ->
                updateActiveStars(v)
                true
            }
            starViewMap[starIndex] = rateStarView
        }
    }

    private fun getPossibleStarViewSize(containerWidth: Int): Int {
        val spacingWidth = (starCount - 1) * starSpacing
        return (containerWidth - spacingWidth) / starCount
    }

    private fun updateStarViewsSize(size: Int) {
        starViewMap.forEach { (_, starView) ->
            starView.updateLayoutParams {
                width = size
                height = size
            }
        }
    }

    private fun handleViewTouch(motionEvent: MotionEvent): Boolean {
        if (motionEvent.action in motionsToDetectSet) {
            val touchX = motionEvent.rawX
            val touchY = motionEvent.rawY
            val currentPressedStar = findCurrentPressedStar(touchX, touchY) ?: return true
            updateActiveStars(currentPressedStar)
        }
        return true
    }

    private fun findCurrentPressedStar(touchX: Float, touchY: Float): View? {
        return starViewMap.values.firstOrNull {
            val starRect = Rect()
            it.getGlobalVisibleRect(starRect)
            starRect.contains(touchX.toInt(), touchY.toInt())
        }
    }

    private fun updateActiveStars(clickedStarView: View) {
        val clickedStarIndex = starViewMap
            .entries
            .firstOrNull { it.value == clickedStarView }
            ?.key

        if (clickedStarIndex != null && clickedStarIndex != currentLastChosenStarIndex) {
            starViewMap.onEach { it.value.isActivated = it.key <= clickedStarIndex }
            onRateChangedAction?.invoke(clickedStarIndex + 1)
            currentLastChosenStarIndex = clickedStarIndex
        }
    }

    private fun obtainAttributes(attributeSet: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.RateView)

        starSpacing = typedArray.getDimensionPixelSize(R.styleable.RateView_starSpacing, 0)
        starCount = typedArray.getInt(R.styleable.RateView_starCount, DEFAULT_RATE_STAR_COUNT)

        typedArray.recycle()
    }

    private companion object {

        const val DEFAULT_RATE_STAR_COUNT = 5
    }
}