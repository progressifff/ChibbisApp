package com.chibbis.f_hits

import com.chibbis.base_feature.ui.viewmodel.BaseViewModel
import com.chibbis.i_hits.HitsInteractor
import javax.inject.Inject

/**
 * Вью модель хитов продаж
 *
 * @property hitsInteractor Интерактор хитов продаж
 */
class HitsViewModel @Inject constructor(
    private val hitsInteractor: HitsInteractor
) : BaseViewModel() {

}