package com.chibbis.f_reviews.data

import com.chibbis.domain.review.Review
import com.chibbis.f_reviews.R
import com.chibbis.f_reviews.databinding.ItemReviewBinding
import com.xwray.groupie.databinding.BindableItem

/**
 * Элемент UI списка отзывов
 */
class ReviewItem(private val review: Review) : BindableItem<ItemReviewBinding>() {
    override fun getLayout(): Int = R.layout.item_review

    override fun getId(): Long = review.hashCode().toLong()

    override fun bind(viewBinding: ItemReviewBinding, position: Int) {
        viewBinding.review = review
    }
}