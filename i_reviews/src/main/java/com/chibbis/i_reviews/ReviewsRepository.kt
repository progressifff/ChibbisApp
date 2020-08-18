package com.chibbis.i_reviews

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.base.tools.extensions.transformCollection
import com.chibbis.domain.review.Review
import javax.inject.Inject

/**
 * Репозиторий отзывов
 *
 * @property reviewsApi Апи отзывов
 */
@ApplicationScope
class ReviewsRepository @Inject constructor(
    private val reviewsApi: ReviewsApi
) {

    /**
     * Получение списка отзывов
     *
     * @return [List] [Review]
     */
    suspend fun getReviews(): List<Review> = reviewsApi.getReviews().transformCollection()
}