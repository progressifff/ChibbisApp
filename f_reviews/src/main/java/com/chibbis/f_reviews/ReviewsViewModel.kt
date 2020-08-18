package com.chibbis.f_reviews

import com.chibbis.base_feature.ui.viewmodel.BaseViewModel
import com.chibbis.i_reviews.ReviewsInteractor
import javax.inject.Inject

/**
 * Вью модель отзывов
 *
 * @property reviewsInteractor Интерактор отзывов
 */
class ReviewsViewModel @Inject constructor(
    private val reviewsInteractor: ReviewsInteractor
) : BaseViewModel() {

}