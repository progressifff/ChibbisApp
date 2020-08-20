package com.chibbis.base_feature.ui.recycler

import com.chibbis.base_feature.BR
import com.chibbis.base_feature.R
import com.xwray.groupie.Group

open class SimpleRecyclerContent<T : Any, S : Group>(
    data: List<T> = emptyList(),
    protected val itemMapper: ((T) -> S)
) : RecyclerContent() {

    protected val emptyDataItem = RecyclerTextItem(R.string.empty_data)

    var data: List<T> = data
        set(value) {
            field = value
            notifyPropertyChanged(BR.recyclerContent)
        }

    override val recyclerContent: List<Group>
        get() = when {
            data.isEmpty() -> listOf(emptyDataItem)
            else -> data.map(itemMapper)
        }
}