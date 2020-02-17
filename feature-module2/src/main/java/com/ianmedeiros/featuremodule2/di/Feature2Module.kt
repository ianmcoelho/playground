package com.ianmedeiros.featuremodule2.di

import com.ianmedeiros.corecontracts.FeatureInteractor
import com.ianmedeiros.featuremodule2.Feature2Interactor

import dagger.Binds
import dagger.Module

@Module
abstract class Feature2Module {

    @Binds
    abstract fun bindInteractor(interactor: Feature2Interactor): FeatureInteractor

}