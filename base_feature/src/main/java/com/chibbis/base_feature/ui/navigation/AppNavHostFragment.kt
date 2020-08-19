package com.chibbis.base_feature.ui.navigation

import androidx.navigation.fragment.NavHostFragment

class AppNavHostFragment : NavHostFragment() {
    override fun createFragmentNavigator() =
        AppFragmentNavigator(requireContext(), childFragmentManager, id)
}