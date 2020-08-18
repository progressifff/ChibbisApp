package com.chibbis.i_restaurants

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.domain.restaurant.Restaurant
import com.chibbis.i_network.RESTAURANTS_URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.GET
import javax.inject.Inject

/**
 * Интеракор для ресторанов
 *
 * @property restaurantsRepository Репозиторий ресторанов
 */
@ApplicationScope
class RestaurantsInteractor @Inject constructor(
    private val restaurantsRepository: RestaurantsRepository
) {

    /**
     * Получение списка ресторанов
     *
     * @return [List] [Restaurant]
     */
    @GET(RESTAURANTS_URL)
    suspend fun getRestaurants(): List<Restaurant> =
        withContext(Dispatchers.IO) {
            restaurantsRepository.getRestaurants()
        }
}