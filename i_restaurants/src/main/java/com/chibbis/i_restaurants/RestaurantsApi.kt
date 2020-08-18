package com.chibbis.i_restaurants

import com.chibbis.i_network.RESTAURANTS_URL
import com.chibbis.i_restaurants.response.RestaurantResponse
import retrofit2.http.GET

/**
 * Апи ресторанов
 */
interface RestaurantsApi {

    /**
     * Получение списка ресторанов
     *
     * @return [List] [RestaurantResponse]
     */
    @GET(RESTAURANTS_URL)
    suspend fun getRestaurants(): List<RestaurantResponse>
}