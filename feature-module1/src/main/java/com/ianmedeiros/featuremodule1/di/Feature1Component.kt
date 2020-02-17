package com.ianmedeiros.featuremodule1.di

import com.ianmedeiros.coremodule.feature.di.FeatureComponent
import dagger.Subcomponent

@Subcomponent(
    modules = [
        Feature1Module::class
    ]
)
interface Feature1Component : FeatureComponent