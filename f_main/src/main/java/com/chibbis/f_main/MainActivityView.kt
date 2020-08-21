package com.chibbis.f_main

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.chibbis.base_feature.ui.tools.extensions.setupWithNavController
import com.chibbis.base_feature.ui.view.BaseActivityView
import kotlinx.android.synthetic.main.activity_main_view.*

/**
 * Вью активити главного экрана
 */
class MainActivityView : BaseActivityView<MainViewModel>() {

    private var currentNavController: LiveData<NavController>? = null

    override val viewModelClass = MainViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_main_view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.restaurants,
            R.navigation.hits,
            R.navigation.reviews,
            R.navigation.more
        )
        val controller = main_navigation_view.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.main_host_fragment,
            intent = intent
        )
        currentNavController = controller
    }
}