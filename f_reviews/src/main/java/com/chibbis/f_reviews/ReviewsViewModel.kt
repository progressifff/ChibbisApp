package com.chibbis.f_reviews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chibbis.base.data.wrapper.LoadStatus
import com.chibbis.base.data.wrapper.LoadableData
import com.chibbis.base_feature.ui.recycler.RecyclerContent
import com.chibbis.base_feature.ui.recycler.RecyclerStubContent
import com.chibbis.base_feature.ui.viewmodel.BaseViewModel
import com.chibbis.domain.review.Review
import com.chibbis.f_reviews.data.ReviewsBundleUi
import com.chibbis.i_reviews.ReviewsInteractor
import kotlinx.coroutines.Job
import javax.inject.Inject

/**
 * Вью модель отзывов
 *
 * @property reviewsInteractor Интерактор отзывов
 */
class ReviewsViewModel @Inject constructor(
    private val reviewsInteractor: ReviewsInteractor
) : BaseViewModel() {

    private val reviewsListMutableLiveData = MutableLiveData<RecyclerContent>()
    private val swrMutableLiveData = MutableLiveData<Boolean>()
    private val reviewsStubContent =
        RecyclerStubContent(layoutRes = R.layout.item_reviews_stub)

    private var loadReviewsJob: Job? = null
    private var reviewsData = LoadableData(
        onMainLoading = ::reactToMainLoading,
        onSwrLoading = ::reactToSwrLoading,
        onDataReady = ::reactToReviewsReady
    )

    val restaurantsListLiveData: LiveData<RecyclerContent> = reviewsListMutableLiveData
    val swrLiveData: LiveData<Boolean> = swrMutableLiveData

    init {
        load()
    }

    fun onRefresh() {
        load(isSwr = true)
    }

    private fun reactToMainLoading(isLoading: Boolean) {
        reviewsListMutableLiveData.postValue(
            reviewsStubContent.apply { this.isLoading = isLoading }
        )
    }

    private fun reactToSwrLoading(isLoading: Boolean) {
        swrMutableLiveData.postValue(isLoading)
    }

    private fun reactToReviewsReady(reviews: List<Review>) {
        reviewsListMutableLiveData.apply {
            when (val value = value) {
                is ReviewsBundleUi -> value.data = reviews
                else -> postValue(ReviewsBundleUi(reviews = reviews))
            }
        }
    }

    private fun load(isSwr: Boolean = false) {
        loadReviewsJob?.cancel()
        loadReviewsJob = doWork(
            {
                reviewsData.update(isSwr = isSwr, loadStatus = LoadStatus.LOADING)
                val restaurants = reviewsInteractor.getReviews()
                reviewsData.update(data = restaurants, loadStatus = LoadStatus.NORMAL)
            },
            {
                reviewsData.update(loadStatus = LoadStatus.ERROR)
            }
        )
    }
}