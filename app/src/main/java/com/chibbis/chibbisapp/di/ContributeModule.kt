package com.chibbis.chibbisapp.di

import com.chibbis.f_hits.di.HitsModule
import com.chibbis.f_restaurants.di.RestaurantsModule
import com.chibbis.f_main.di.MainModule
import com.chibbis.f_reviews.di.ReviewsModule
import dagger.Module

@Module(
    includes = [
        MainModule::class,
        RestaurantsModule::class,
        ReviewsModule::class,
        HitsModule::class
    ]
)
abstract class ContributeModule