package com.chibbis.f_hits.data

import android.graphics.drawable.Drawable
import com.chibbis.base_feature.ui.recycler.SimpleRecyclerContent
import com.chibbis.domain.hit.Hit

/**
 * Хиты продаж для UI
 */
class HitsBundleUi(
    hits: List<Hit>,
    onHitImageLongClick: (Drawable) -> Unit
) : SimpleRecyclerContent<Hit, HitItem>(
    data = hits,
    itemMapper = { HitItem(it, onHitImageLongClick) }
)