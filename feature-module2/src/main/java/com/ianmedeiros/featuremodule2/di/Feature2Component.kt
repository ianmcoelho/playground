package com.ianmedeiros.featuremodule2.di

import androidx.fragment.app.FragmentActivity
import com.ianmedeiros.coremodule.feature.di.FeatureApplicationRoot
import com.ianmedeiros.coremodule.feature.di.FeaturePresentationRoot
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        Feature2Module::class
    ]
)
interface Feature2Component : FeaturePresentationRoot {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: FragmentActivity,
            @BindsInstance featureApplicationRoot: FeatureApplicationRoot
        ): Feature2Component
    }
}