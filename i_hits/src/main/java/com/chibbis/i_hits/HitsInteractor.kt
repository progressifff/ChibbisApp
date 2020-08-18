package com.chibbis.i_hits

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Интеракор хитов продаж
 *
 * @property hitsRepository Репозиторий хитов продаж
 */
@Singleton
class HitsInteractor @Inject constructor(
    private val hitsRepository: HitsRepository
) {

}