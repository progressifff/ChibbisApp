package com.chibbis.f_restaurants.data

import com.chibbis.base_feature.BR
import com.chibbis.base_feature.ui.recycler.RecyclerTextItem
import com.chibbis.base_feature.ui.recycler.SimpleRecyclerContent
import com.chibbis.domain.restaurant.Restaurant
import com.chibbis.f_restaurants.R
import com.xwray.groupie.Group

/**
 * Набор данных о ресторанах
 */
class RestaurantsBundleUi(
    restaurants: List<Restaurant> = emptyList(),
    filter: String = ""
) : SimpleRecyclerContent<Restaurant, RestaurantItem>(
    data = restaurants,
    itemMapper = { RestaurantItem(it) }
) {

    private val noDataFoundItem = RecyclerTextItem(R.string.no_data_found)

    var filter: String = filter
        set(value) {
            field = value
            notifyPropertyChanged(BR.recyclerContent)
        }

    override val recyclerContent: List<Group>
        get() {
            return when {
                data.isEmpty() -> listOf(emptyDataItem)
                else -> {
                    val filtered =
                        data.filter { it.name.contains(filter, ignoreCase = true) }
                    when {
                        filtered.isEmpty() -> listOf(noDataFoundItem)
                        else -> filtered.map(itemMapper)
                    }
                }
            }
        }
}