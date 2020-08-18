package com.chibbis.i_hits

import com.chibbis.i_hits.response.HitResponse
import com.chibbis.i_network.HITS_URL
import retrofit2.http.GET

/**
 * Апи хитов продаж
 */
interface HitsApi {

    /**
     * Получение списка хитов продаж
     *
     * @return [List] от [HitResponse]
     */
    @GET(HITS_URL)
    suspend fun getHits(): List<HitResponse>
}