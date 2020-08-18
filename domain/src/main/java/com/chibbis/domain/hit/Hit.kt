package com.chibbis.domain.hit

import java.math.BigDecimal

/**
 * Информация про хит продаж
 *
 * @property productName Имя продукта
 * @property productImageUrl Изображение продукта
 * @property id Айди ресторана
 * @property productPriceRub Цена продукта в рублях
 * @property productDescription Описание продукта
 * @property restaurantLogoUrl Лого ресторана
 * @property restaurantName Имя ресторана
 */
data class Hit(
    val id: String,
    val productName: String,
    val productImageUrl: String,
    val productPriceRub: BigDecimal,
    val productDescription: String,
    val restaurantLogoUrl: String,
    val restaurantName: String
)