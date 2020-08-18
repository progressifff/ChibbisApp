package com.chibbis.i_reviews

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.domain.review.Review
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Интеракор отзывов
 *
 * @property reviewsRepository Репозиторий отзывов
 */
@ApplicationScope
class ReviewsInteractor @Inject constructor(
    private val reviewsRepository: ReviewsRepository
) {

    /**
     * Получение списка отзывов
     *
     * @return [List] [Review]
     */
    suspend fun getReviews(): List<Review> = withContext(Dispatchers.IO) {
        reviewsRepository.getReviews()
    }
}