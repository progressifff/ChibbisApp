package com.chibbis.i_restaurants

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Репозиторий ресторанов
 */
@Singleton
class RestaurantsRepository @Inject constructor(
    private val restaurantsApi: RestaurantsApi
) {

}