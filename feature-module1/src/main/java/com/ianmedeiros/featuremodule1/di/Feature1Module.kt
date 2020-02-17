package com.ianmedeiros.featuremodule1.di

import com.ianmedeiros.corecontracts.FeatureInteractor
import com.ianmedeiros.featuremodule1.Feature1Interactor
import dagger.Binds
import dagger.Module

@Module
abstract class Feature1Module {

    @Binds
    abstract fun bindInteractor(interactor: Feature1Interactor): FeatureInteractor

}