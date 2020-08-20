package com.chibbis.f_restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chibbis.base.data.wrapper.LoadStatus
import com.chibbis.base.data.wrapper.LoadableData
import com.chibbis.base_feature.ui.recycler.RecyclerContent
import com.chibbis.base_feature.ui.recycler.RecyclerStubContent
import com.chibbis.base_feature.ui.viewmodel.BaseViewModel
import com.chibbis.domain.restaurant.Restaurant
import com.chibbis.f_restaurants.data.RestaurantsBundleUi
import com.chibbis.i_restaurants.RestaurantsInteractor
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * Вью модель ресторанов
 *
 * @property restaurantsInteractor Интерактор ресторанов
 */
class RestaurantsViewModel @Inject constructor(
    private val restaurantsInteractor: RestaurantsInteractor
) : BaseViewModel() {

    private val restaurantsListMutableLiveData = MutableLiveData<RecyclerContent>()
    private val swrMutableLiveData = MutableLiveData<Boolean>()
    private val restaurantsStubContent =
        RecyclerStubContent(layoutRes = R.layout.item_restaurants_stub)

    private var loadRestaurantsJob: Job? = null
    private var restaurantsData = LoadableData(
        onMainLoading = ::reactToMainLoading,
        onSwrLoading = ::reactToSwrLoading,
        onDataReady = ::reactToRestaurantsReady
    )

    val restaurantsListLiveData: LiveData<RecyclerContent> = restaurantsListMutableLiveData
    val swrLiveData: LiveData<Boolean> = swrMutableLiveData

    init {
        load()
    }

    fun onRestaurantSearch(query: String) {
        (restaurantsListMutableLiveData.value as? RestaurantsBundleUi)?.filter = query
    }

    fun onRefresh() {
        load(isSwr = true)
    }

    private fun reactToMainLoading(isLoading: Boolean) {
        restaurantsListMutableLiveData.postValue(
            restaurantsStubContent.apply { this.isLoading = isLoading }
        )
    }

    private fun reactToSwrLoading(isLoading: Boolean) {
        swrMutableLiveData.postValue(isLoading)
    }

    private fun reactToRestaurantsReady(restaurants: List<Restaurant>) {
        restaurantsListMutableLiveData.apply {
            when (val value = value) {
                is RestaurantsBundleUi -> value.data = restaurants
                else -> postValue(RestaurantsBundleUi(restaurants = restaurants))
            }
        }
    }

    private fun load(isSwr: Boolean = false) {
        loadRestaurantsJob?.cancel()
        loadRestaurantsJob = doWork(
            {
                restaurantsData.update(isSwr = isSwr, loadStatus = LoadStatus.LOADING)
                delay(3000)
                val restaurants = restaurantsInteractor.getRestaurants()
                restaurantsData.update(data = restaurants, loadStatus = LoadStatus.NORMAL)
            },
            {
                restaurantsData.update(loadStatus = LoadStatus.ERROR)
            }
        )
    }
}