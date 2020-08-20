package com.chibbis.f_reviews.data

import com.chibbis.base_feature.ui.recycler.SimpleRecyclerContent
import com.chibbis.domain.review.Review

/**
 * Ревью для UI
 */
class ReviewsBundleUi(
    reviews: List<Review>
) : SimpleRecyclerContent<Review, ReviewItem>(
    data = reviews,
    itemMapper = { ReviewItem(it) }
)