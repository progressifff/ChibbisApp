package com.chibbis.i_hits

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.domain.hit.Hit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Интеракор хитов продаж
 *
 * @property hitsRepository Репозиторий хитов продаж
 */
@ApplicationScope
class HitsInteractor @Inject constructor(
    private val hitsRepository: HitsRepository
) {

    /**
     * Получение списка хитов продаж
     *
     * @return [List] от [Hit]
     */
    suspend fun getHits(): List<Hit> = withContext(Dispatchers.IO) {
        hitsRepository.getHits()
    }
}