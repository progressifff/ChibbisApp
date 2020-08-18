package com.chibbis.i_reviews

import com.chibbis.i_network.REVIEWS_URL
import com.chibbis.i_reviews.response.ReviewResponse
import retrofit2.http.GET

/**
 * Апи отзывов
 */
interface ReviewsApi {

    /**
     * Получение списка отзывов
     *
     * @return [List] [ReviewResponse]
     */
    @GET(REVIEWS_URL)
    suspend fun getReviews(): List<ReviewResponse>
}