package com.chibbis.i_reviews.response

import com.chibbis.base.mappers.nonNull
import com.chibbis.base.transform.Transformable
import com.chibbis.domain.review.Review
import com.chibbis.i_network.tryParseLocalDateFromServer
import com.squareup.moshi.Json

/**
 * Ответ отзыва о ресторане
 *
 * @property userFIO ФИО пользователя
 * @property message Сообщение
 * @property dateAdded Дата
 * @property restaurantName Имя ресторана
 * @property isPositive Признак положительного отзыва
 */
data class ReviewResponse(

    @field:Json(name = "UserFIO")
    val userFIO: String? = null,

    @field:Json(name = "Message")
    val message: String? = null,

    @field:Json(name = "DateAdded")
    val dateAdded: String? = null,

    @field:Json(name = "RestaurantName")
    val restaurantName: String? = null,

    @field:Json(name = "IsPositive")
    val isPositive: Boolean? = null

) : Transformable<Review> {

    override fun transform(): Review = Review(
        userFIO = userFIO.nonNull,
        date = tryParseLocalDateFromServer(dateAdded),
        isPositive = isPositive.nonNull,
        message = message.nonNull,
        restaurantName = restaurantName.nonNull
    )
}