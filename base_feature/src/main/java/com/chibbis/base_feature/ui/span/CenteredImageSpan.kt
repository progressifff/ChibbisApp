package com.chibbis.base_feature.ui.span

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.text.style.ImageSpan
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.chibbis.base_feature.ui.tools.util.Size
import java.lang.ref.WeakReference

/**
 * Спан с картинкой. Обеспечивает вертикальное центрирование на основе фактического размера букв.
 * Он поддерживает центрирование с использованием заглавных и строчных букв.
 * Также можно установить кастомные размеры Drawable
 */
class CenteredImageSpan(
    drawable: Drawable,
    private val centerType: CenterType = CenterType.CAPITAL_LETTER,
    private val customSize: Size? = null
) : ImageSpan(drawable) {

    constructor(
        context: Context,
        @DrawableRes drawableRes: Int,
        centerType: CenterType = CenterType.CAPITAL_LETTER,
        customSize: Size? = null
    ) : this(
        ContextCompat.getDrawable(context, drawableRes) ?: ShapeDrawable(),
        centerType,
        customSize
    )

    private var mDrawableRef: WeakReference<Drawable?>? = null

    override fun getSize(
        paint: Paint, text: CharSequence,
        start: Int, end: Int,
        fontMetrics: Paint.FontMetricsInt?
    ): Int {

        if (fontMetrics != null) {
            val currentFontMetrics = paint.fontMetricsInt
            // keep it the same as paint's Font Metrics
            fontMetrics.ascent = currentFontMetrics.ascent
            fontMetrics.descent = currentFontMetrics.descent
            fontMetrics.top = currentFontMetrics.top
            fontMetrics.bottom = currentFontMetrics.bottom
        }

        val drawable = getCachedDrawable()
        val rect = drawable.bounds
        return rect.right
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence,
        start: Int,
        end: Int,
        x: Float,
        lineTop: Int,
        baselineY: Int,
        lineBottom: Int,
        paint: Paint
    ) {
        val cachedDrawable = getCachedDrawable()
        val drawableHeight = cachedDrawable.bounds.height()

        val relativeVerticalCenter = getLetterVerticalCenter(paint)

        val drawableCenter = baselineY + relativeVerticalCenter
        val drawableBottom = drawableCenter - drawableHeight / 2

        canvas.save()
        canvas.translate(x, drawableBottom.toFloat())
        cachedDrawable.draw(canvas)
        canvas.restore()
    }

    private fun getLetterVerticalCenter(paint: Paint): Int =
        when (centerType) {
            CenterType.CAPITAL_LETTER -> getCapitalVerticalCenter(paint)
            CenterType.LOWER_CASE_LETTER -> getLowerCaseVerticalCenter(paint)
        }

    private fun getCapitalVerticalCenter(paint: Paint): Int {
        val bounds = Rect()
        paint.getTextBounds("X", 0, 1, bounds)
        return (bounds.bottom + bounds.top) / 2
    }

    private fun getLowerCaseVerticalCenter(paint: Paint): Int {
        val bounds = Rect()
        paint.getTextBounds("x", 0, 1, bounds)
        return (bounds.bottom + bounds.top) / 2
    }

    // Redefined here because it's private in DynamicDrawableSpan
    private fun getCachedDrawable(): Drawable {

        val drawableWeakReference = mDrawableRef
        var drawable: Drawable? = null
        if (drawableWeakReference != null) drawable = drawableWeakReference.get()
        if (drawable == null) {
            drawable = getDrawable()!!

            val width = customSize?.width ?: drawable.intrinsicWidth
            val height = customSize?.height ?: drawable.intrinsicHeight

            drawable.setBounds(
                0, 0,
                width, height
            )
            mDrawableRef = WeakReference(drawable)
        }
        return drawable
    }

    enum class CenterType {
        CAPITAL_LETTER, LOWER_CASE_LETTER
    }
}