package com.ianmedeiros.playground.di

import android.content.Context
import com.ianmedeiros.featuremodule1.di.Feature1ComponentRoot
import com.ianmedeiros.featuremodule2.di.Feature2ComponentRoot
import com.ianmedeiros.playground.di.modules.FeatureApplicationModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        FeatureApplicationModule::class
    ]
)
interface ApplicationComponent :
    Feature1ComponentRoot,
    Feature2ComponentRoot {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}