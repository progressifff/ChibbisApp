package com.chibbis.i_restaurants.response

import com.chibbis.base.convertes.safeConvertToBigDecimal
import com.chibbis.base.mappers.nonNull
import com.chibbis.base.transform.Transformable
import com.chibbis.domain.restaurant.Restaurant
import com.squareup.moshi.Json

/**
 * Ответ данных о ресторане
 *
 * @property deliveryTime
 * @property minCost
 * @property specializations
 * @property deliveryCost
 * @property positiveReviews
 * @property name
 * @property logo
 * @property reviewsCount
 */
data class RestaurantResponse(

    @field:Json(name = "DeliveryTime")
    val deliveryTime: Int? = null,

    @field:Json(name = "MinCost")
    val minCost: String? = null,

    @field:Json(name = "Specializations")
    val specializations: List<RestaurantSpecializationObj?>? = null,

    @field:Json(name = "DeliveryCost")
    val deliveryCost: String? = null,

    @field:Json(name = "PositiveReviews")
    val positiveReviews: Int? = null,

    @field:Json(name = "Name")
    val name: String? = null,

    @field:Json(name = "Logo")
    val logo: String? = null,

    @field:Json(name = "ReviewsCount")
    val reviewsCount: Int? = null
) : Transformable<Restaurant> {

    override fun transform(): Restaurant =
        Restaurant(
            name = name.nonNull,
            deliveryCostRubs = safeConvertToBigDecimal(deliveryCost),
            deliveryTimeMinutes = deliveryTime.nonNull,
            logoUrl = logo.nonNull,
            minCostRubs = safeConvertToBigDecimal(minCost),
            positiveReviewsCount = positiveReviews.nonNull,
            specializations = specializations.nonNull.map { it.transform() },
            totalReviewCount = reviewsCount.nonNull
        )
}