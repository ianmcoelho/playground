package com.ianmedeiros.coremodule.feature.di

import dagger.Module
import dagger.Provides

@Module
abstract class FeatureModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideTracking(featureApplicationRoot: FeatureApplicationRoot) = featureApplicationRoot.tracking
    }
}