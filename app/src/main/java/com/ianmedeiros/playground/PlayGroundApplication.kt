package com.ianmedeiros.playground

import android.app.Application
import com.ianmedeiros.coremodule.di.CompositionRoot
import com.ianmedeiros.playground.di.ApplicationComponent
import com.ianmedeiros.playground.di.DaggerApplicationComponent

class PlayGroundApplication : Application(), CompositionRoot<ApplicationComponent> {

    override val root: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}