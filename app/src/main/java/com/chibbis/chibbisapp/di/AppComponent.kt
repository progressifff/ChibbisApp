package com.chibbis.chibbisapp.di

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.base_feature.di.ErrorHandlerModule
import com.chibbis.chibbisapp.App
import com.chibbis.f_more.di.MoreModule
import com.chibbis.f_restaurants.di.RestaurantsModule
import com.chibbis.i_hits.di.HitsInteractorModule
import com.chibbis.i_network.di.NetworkModule
import com.chibbis.i_restaurants.di.RestaurantsInteractorModule
import com.chibbis.i_reviews.di.ReviewsInteractorModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ContributeModule::class,
        ErrorHandlerModule::class,
        NetworkModule::class,
        RestaurantsModule::class,
        MoreModule::class,
        RestaurantsInteractorModule::class,
        ReviewsInteractorModule::class,
        HitsInteractorModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }
}