package com.chibbis.base_feature.ui.tools.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.chibbis.base_feature.consts.EMPTY_STRING
import com.chibbis.base_feature.consts.SPACE_CHAR
import com.chibbis.base_feature.ui.span.CenteredImageSpan
import com.chibbis.base_feature.ui.tools.util.Size

/**
 * Включение картинки в текст.
 *
 * @param context Контекст
 * @param drawableRes Ресурс картинки
 * @param position Позиция вставки
 * @param imagePrefix Символы перед картинкой
 * @param imagePostfix Символы после картинки
 * @param imageSize Размер картинки
 */
fun SpannableStringBuilder.insertImage(
    context: Context,
    @DrawableRes drawableRes: Int,
    position: Int = 0,
    imagePrefix: CharSequence = EMPTY_STRING,
    imagePostfix: CharSequence = EMPTY_STRING,
    imageSize: Size? = null
): SpannableStringBuilder {
    return insertImage(
        ContextCompat.getDrawable(context, drawableRes) ?: ShapeDrawable(),
        position,
        imagePrefix,
        imagePostfix,
        imageSize
    )
}

/**
 * Включение картинки в текст.
 *
 * @param drawable Картинка
 * @param position Позиция вставки
 * @param imagePrefix Символы перед картинкой
 * @param imagePostfix Символы после картинки
 * @param imageSize Размер картинки
 */
fun SpannableStringBuilder.insertImage(
    drawable: Drawable,
    position: Int = 0,
    imagePrefix: CharSequence = EMPTY_STRING,
    imagePostfix: CharSequence = EMPTY_STRING,
    imageSize: Size? = null
): SpannableStringBuilder {
    val imageSpan = CenteredImageSpan(drawable, customSize = imageSize)
    val placementString = "$imagePrefix$SPACE_CHAR$imagePostfix"
    val placementStringPosition = when {
        position < 0 -> 0
        position >= length -> length
        else -> position
    }
    insert(placementStringPosition, placementString)
    val imageStartIndex = imagePrefix.length + placementStringPosition
    val imageEndIndex = imageStartIndex + 1
    setSpan(
        imageSpan,
        imageStartIndex,
        imageEndIndex,
        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
    )
    return this
}

/**
 * Применяет цвет к строке
 */
fun SpannableStringBuilder.applyForegroundSpan(
    context: Context,
    @ColorRes foregroundColorRes: Int,
    startIndex: Int = 0,
    endIndex: Int = length
): CharSequence {
    val textColor = ContextCompat.getColor(context, foregroundColorRes)
    val foregroundSpan = ForegroundColorSpan(textColor)
    return this.apply {
        setSpan(
            foregroundSpan,
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
}