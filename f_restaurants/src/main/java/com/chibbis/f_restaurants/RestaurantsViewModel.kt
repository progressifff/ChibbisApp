package com.chibbis.f_restaurants

import com.chibbis.base_feature.ui.viewmodel.BaseViewModel
import com.chibbis.i_restaurants.RestaurantsInteractor
import javax.inject.Inject

/**
 * Вью модель ресторанов
 *
 * @property restaurantsInteractor Интерактор ресторанов
 */
class RestaurantsViewModel @Inject constructor(
    private val restaurantsInteractor: RestaurantsInteractor
) : BaseViewModel() {

}