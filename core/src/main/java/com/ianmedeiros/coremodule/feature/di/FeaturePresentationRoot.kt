package com.ianmedeiros.coremodule.feature.di

import com.ianmedeiros.coremodule.feature.FeatureFragment

interface FeaturePresentationRoot {
    fun inject(featureFragment: FeatureFragment)
}