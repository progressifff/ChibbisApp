package com.chibbis.i_restaurants.response

import com.chibbis.base.mappers.nonNull
import com.chibbis.base.transform.Transformable
import com.squareup.moshi.Json

/**
 * Объект специализация ресторана
 */
data class RestaurantSpecializationObj(

    @field:Json(name = "Name")
    val name: String? = null
) : Transformable<String> {
    override fun transform(): String = name.nonNull
}