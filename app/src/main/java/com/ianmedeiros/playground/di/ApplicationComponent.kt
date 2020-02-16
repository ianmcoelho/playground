package com.ianmedeiros.playground.di

import android.content.Context
import com.ianmedeiros.coremodule.feature.di.FeatureApplicationRoot
import com.ianmedeiros.playground.di.modules.FeatureApplicationModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        FeatureApplicationModule::class
    ]
)
interface ApplicationComponent :
    FeatureApplicationRoot {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}