package com.chibbis.base_feature.ui.tools.extensions

import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

fun GroupAdapter<GroupieViewHolder>.containsItem(contentItem: Item): Boolean {
    return try {
        getGroup(contentItem)
        true
    } catch (e: Exception) {
        false
    }
}

fun GroupAdapter<GroupieViewHolder>.tryRemove(contentItem: Item) {
    if (containsItem(contentItem)) {
        remove(contentItem)
    }
}

fun <T: Group>GroupAdapter<*>.setGroups(items: Collection<T>) {
    clear()
    addAll(items)
}