package com.chibbis.i_restaurants

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Интеракор для ресторанов
 *
 * @property restaurantsRepository Репозиторий ресторанов
 */
@Singleton
class RestaurantsInteractor @Inject constructor(
    private val restaurantsRepository: RestaurantsRepository
) {

}