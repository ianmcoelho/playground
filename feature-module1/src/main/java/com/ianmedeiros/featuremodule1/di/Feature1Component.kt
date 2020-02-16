package com.ianmedeiros.featuremodule1.di

import androidx.fragment.app.FragmentActivity
import com.ianmedeiros.coremodule.feature.di.FeatureApplicationRoot
import com.ianmedeiros.coremodule.feature.di.FeaturePresentationRoot
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        Feature1Module::class
    ]
)
interface Feature1Component : FeaturePresentationRoot {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: FragmentActivity,
            @BindsInstance featureApplicationRoot: FeatureApplicationRoot
        ): Feature1Component
    }
}