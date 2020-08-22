package com.chibbis.f_restaurants.data

import com.chibbis.domain.restaurant.Restaurant
import com.chibbis.f_restaurants.R
import com.chibbis.f_restaurants.databinding.ItemRestaurantBinding
import com.xwray.groupie.databinding.BindableItem

/**
 * Элемент UI списка ресторанов
 */
data class RestaurantItem(val restaurant: Restaurant) : BindableItem<ItemRestaurantBinding>() {
    override fun getLayout(): Int = R.layout.item_restaurant

    override fun getId(): Long = restaurant.name.hashCode().toLong()

    override fun bind(viewBinding: ItemRestaurantBinding, position: Int) {
        viewBinding.restaurant = restaurant
    }
}