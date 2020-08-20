package com.chibbis.base_feature.ui.tools.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.SpannableStringBuilder
import androidx.core.content.ContextCompat
import com.chibbis.base_feature.R
import com.chibbis.base_feature.consts.BULLET_CHAR
import com.chibbis.base_feature.consts.SPACE_CHAR
import com.chibbis.base_feature.ui.tools.util.Size
import com.chibbis.domain.hit.Hit
import com.chibbis.domain.restaurant.Restaurant
import com.chibbis.domain.review.Review
import java.text.SimpleDateFormat
import java.util.*

fun Restaurant.getSpecialization(): CharSequence = specializations.joinToString(
    separator = "$SPACE_CHAR$BULLET_CHAR$SPACE_CHAR"
)

fun Restaurant.getReviews(context: Context): CharSequence {
    val totalReviewCountString = context.resources.getQuantityString(
        R.plurals.reviews_count_plurals,
        totalReviewCount,
        totalReviewCount
    )
    return if (totalReviewCount > 0) {
        val positiveReviewsPercents = (positiveReviewsCount / totalReviewCount) * 100
        val reviewsCount = context.getString(
            R.string.reviews_count,
            positiveReviewsPercents,
            totalReviewCountString
        )
        SpannableStringBuilder(reviewsCount).apply {
            insertImage(
                context = context,
                drawableRes = R.drawable.ic_baseline_thumb_up,
                imagePostfix = SPACE_CHAR.toString(),
                imageSize = with(context.resources.getDimensionPixelOffset(R.dimen.review_thumbs_up_size)) {
                    Size(width = this, height = this)
                }
            )
            applyForegroundSpan(
                context = context,
                foregroundColorRes = R.color.colorPositive,
                endIndex = this.indexOf(BULLET_CHAR)
            )
        }
    } else {
        totalReviewCountString
    }
}

fun Restaurant.getDeliveryTime(context: Context): CharSequence =
    context.getString(R.string.restaurant_delivery_time_text, deliveryTimeMinutes)

fun Restaurant.getMinCost(context: Context): CharSequence =
    context.getString(R.string.restaurant_min_cost_text, minCostRubs)

fun Restaurant.getDeliveryCost(context: Context): CharSequence =
    context.getString(R.string.price_text, minCostRubs)

fun Hit.getComposition(context: Context): CharSequence =
    context.getString(R.string.hit_composition_text, productDescription)

fun Hit.getPrice(context: Context): CharSequence =
    context.getString(R.string.price_text, productPriceRub)

fun Review.getSmile(context: Context): Drawable? =
    when (isPositive) {
        true -> R.drawable.ic_smile
        else -> R.drawable.ic_sad
    }.let { ContextCompat.getDrawable(context, it) }

fun Review.getFormattedDate(): CharSequence {
    val dateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
    return dateFormat.format(date)
}
