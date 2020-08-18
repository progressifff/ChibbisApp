package com.chibbis.domain.review

import java.util.*

/**
 * Отзыв о ресторане
 *
 * @property userFIO ФИО пользователя
 * @property message Сообщение
 * @property date Дата
 * @property restaurantName Имя ресторана
 * @property isPositive Признак положительного отзыва
 */
data class Review(
    val userFIO: String,
    val message: String,
    val date: Date,
    val restaurantName: String,
    val isPositive: Boolean
)