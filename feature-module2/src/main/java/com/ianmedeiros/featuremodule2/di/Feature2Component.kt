package com.ianmedeiros.featuremodule2.di

import com.ianmedeiros.coremodule.feature.di.FeatureComponent
import dagger.Subcomponent

@Subcomponent(
    modules = [
        Feature2Module::class
    ]
)
interface Feature2Component : FeatureComponent