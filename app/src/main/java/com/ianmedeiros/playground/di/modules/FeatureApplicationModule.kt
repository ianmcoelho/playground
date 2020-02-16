package com.ianmedeiros.playground.di.modules

import com.ianmedeiros.corecontracts.FeatureTracking
import com.ianmedeiros.playground.PlaygroundFeatureTracking
import dagger.Binds
import dagger.Module

@Module
abstract class FeatureApplicationModule {

    @Binds
    abstract fun bindFeatureTracking(tracking: PlaygroundFeatureTracking): FeatureTracking

}