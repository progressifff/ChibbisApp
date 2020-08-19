package com.chibbis.base_feature.ui.recycler

import androidx.annotation.LayoutRes
import com.chibbis.base_feature.BR
import com.xwray.groupie.Group

class RecyclerStubContent(
    @LayoutRes private val layoutRes: Int,
    isLoading: Boolean = false
) : RecyclerContent() {

    var isLoading: Boolean = isLoading
        set(value) {
            field = value
            notifyPropertyChanged(BR.recyclerContent)
        }

    override val recyclerContent: List<Group>
        get() = listOf(RecyclerStubItem(layoutRes, isLoading))
}