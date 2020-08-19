package com.chibbis.f_restaurants.data

import com.chibbis.base_feature.BR
import com.chibbis.base_feature.ui.recycler.RecyclerContent
import com.chibbis.base_feature.ui.recycler.RecyclerTextItem
import com.chibbis.domain.restaurant.Restaurant
import com.chibbis.f_restaurants.R
import com.xwray.groupie.Group

/**
 * Набор данных о ресторанах
 */
class RestaurantsBundleUi(
    restaurants: List<Restaurant> = emptyList(),
    filter: String = ""
) : RecyclerContent() {

    private val emptyDataItem = RecyclerTextItem(R.string.empty_data)
    private val noDataFoundItem = RecyclerTextItem(R.string.no_data_found)

    var restaurants: List<Restaurant> = restaurants
        set(value) {
            field = value
            notifyPropertyChanged(BR.recyclerContent)
        }

    var filter: String = filter
        set(value) {
            field = value
            notifyPropertyChanged(BR.recyclerContent)
        }

    override val recyclerContent: List<Group>
        get() {
            return when {
                restaurants.isEmpty() -> listOf(emptyDataItem)
                else -> {
                    val filtered =
                        restaurants.filter { it.name.contains(filter, ignoreCase = true) }
                    when {
                        filtered.isEmpty() -> listOf(noDataFoundItem)
                        else -> filtered.map { RestaurantItem(it) }
                    }
                }
            }
        }
}