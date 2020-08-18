package com.chibbis.domain.restaurant

import java.math.BigDecimal

/**
 * Информация о ресторане
 *
 * @property name Имя ресторана
 * @property logoUrl Лого ресторана
 * @property deliveryTimeMinutes Время доставки в минутах
 * @property minCostRubs Минимальная стоимость
 * @property specializations Специализации ресторана
 * @property deliveryCostRubs Стоимость доставка рублей
 * @property positiveReviewsCount Количество позитивных отзывов
 * @property totalReviewCount Общее количество позитивных отзывов
 */
data class Restaurant(
    val name: String,
    val logoUrl: String,
    val deliveryTimeMinutes: Int,
    val minCostRubs: BigDecimal,
    val specializations: List<String>,
    val deliveryCostRubs: BigDecimal,
    val positiveReviewsCount: Int,
    val totalReviewCount: Int
)