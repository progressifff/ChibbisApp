package com.chibbis.i_reviews

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Интеракор отзывов
 *
 * @property reviewsRepository Репозиторий отзывов
 */
@Singleton
class ReviewsInteractor @Inject constructor(
    private val reviewsRepository: ReviewsRepository
) {

}