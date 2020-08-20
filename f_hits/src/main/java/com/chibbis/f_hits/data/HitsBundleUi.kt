package com.chibbis.f_hits.data

import com.chibbis.base_feature.ui.recycler.SimpleRecyclerContent
import com.chibbis.domain.hit.Hit

/**
 * Хиты продаж для UI
 */
class HitsBundleUi(
    hits: List<Hit>
) : SimpleRecyclerContent<Hit, HitItem>(
    data = hits,
    itemMapper = { HitItem(it) }
)