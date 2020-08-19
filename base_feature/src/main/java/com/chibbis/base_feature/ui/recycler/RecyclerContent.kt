package com.chibbis.base_feature.ui.recycler

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.xwray.groupie.Group

abstract class RecyclerContent : BaseObservable() {

    abstract val recyclerContent: List<Group>
        @Bindable get
}