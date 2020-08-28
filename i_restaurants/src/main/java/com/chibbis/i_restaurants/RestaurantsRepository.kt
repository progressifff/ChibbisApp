package com.chibbis.i_restaurants

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.base.tools.extensions.transformCollection
import com.chibbis.domain.restaurant.Restaurant
import javax.inject.Inject

/**
 * Репозиторий ресторанов
 */
@ApplicationScope
class RestaurantsRepository @Inject constructor(
    private val restaurantsApi: RestaurantsApi
) {

    /**
     * Получение списка ресторанов
     *
     * @return [List] [Restaurant]
     */
    suspend fun getRestaurants(): List<Restaurant> =
        restaurantsApi.getRestaurants().transformCollection()
}