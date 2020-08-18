package com.chibbis.i_hits

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Репозиторий хитов продаж
 *
 * @property hitsApi Апи хитов продаж
 */
@Singleton
class HitsRepository @Inject constructor(
    private val hitsApi: HitsApi
) {

}