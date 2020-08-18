package com.chibbis.i_hits

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.base.tools.extensions.transformCollection
import com.chibbis.domain.hit.Hit
import javax.inject.Inject

/**
 * Репозиторий хитов продаж
 *
 * @property hitsApi Апи хитов продаж
 */
@ApplicationScope
class HitsRepository @Inject constructor(
    private val hitsApi: HitsApi
) {

    /**
     * Получение списка хитов продаж
     *
     * @return [List] от [Hit]
     */
    suspend fun getHits(): List<Hit> = hitsApi.getHits().transformCollection()
}