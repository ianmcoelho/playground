package com.ianmedeiros.coremodule.feature.di

import com.ianmedeiros.coremodule.feature.FeatureFragment

interface FeatureComponent {
    fun inject(featureFragment: FeatureFragment)
}