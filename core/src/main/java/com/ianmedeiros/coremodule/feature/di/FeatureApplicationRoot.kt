package com.ianmedeiros.coremodule.feature.di

import com.ianmedeiros.corecontracts.FeatureTracking

interface FeatureApplicationRoot {

    val tracking: FeatureTracking

}