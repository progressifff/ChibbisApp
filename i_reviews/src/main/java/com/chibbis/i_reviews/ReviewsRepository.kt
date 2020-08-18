package com.chibbis.i_reviews

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Репозиторий отзывов
 *
 * @property reviewsApi Апи отзывов
 */
@Singleton
class ReviewsRepository @Inject constructor(
    private val reviewsApi: ReviewsApi
) {

}