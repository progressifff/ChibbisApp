package com.chibbis.i_hits.response

import com.chibbis.base.convertes.safeConvertToBigDecimal
import com.chibbis.base.mappers.nonNull
import com.chibbis.base.transform.Transformable
import com.chibbis.domain.hit.Hit
import com.squareup.moshi.Json

/**
 * Ответ хита продаж
 *
 * @property productName Имя продукта
 * @property productImage Изображение продукта
 * @property restaurantId Айди ресторана
 * @property productPrice Цена продукта в рублях
 * @property productDescription Описание продукта
 * @property restaurantLogo Лого ресторана
 * @property restaurantName Имя ресторана
 */
data class HitResponse(

    @field:Json(name = "ProductName")
    val productName: String? = null,

    @field:Json(name = "ProductImage")
    val productImage: String? = null,

    @field:Json(name = "RestaurantId")
    val restaurantId: String? = null,

    @field:Json(name = "ProductPrice")
    val productPrice: String? = null,

    @field:Json(name = "ProductDescription")
    val productDescription: String? = null,

    @field:Json(name = "RestaurantLogo")
    val restaurantLogo: String? = null,

    @field:Json(name = "RestaurantName")
    val restaurantName: String? = null
) : Transformable<Hit> {

    override fun transform(): Hit = Hit(
        id = restaurantId.nonNull,
        restaurantName = restaurantName.nonNull,
        productDescription = productDescription.nonNull,
        productImageUrl = productImage.nonNull,
        productName = productName.nonNull,
        productPriceRub = safeConvertToBigDecimal(productPrice),
        restaurantLogoUrl = restaurantLogo.nonNull
    )
}
