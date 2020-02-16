package com.ianmedeiros.coremodule.feature

import com.ianmedeiros.corecontracts.FeatureContent
import com.ianmedeiros.corecontracts.FeatureInteractor
import com.ianmedeiros.corecontracts.FeatureTracking
import com.ianmedeiros.corecontracts.ON_LOAD_CONTENT
import javax.inject.Inject

interface Feature {
    suspend fun content(): FeatureContent
}

class FeatureInteractor @Inject constructor(
    private val tracking: FeatureTracking,
    private val feature: Feature
) : FeatureInteractor {

    override suspend fun loadFeatureContent(): FeatureContent {
        tracking.onEvent(ON_LOAD_CONTENT)
        return feature.content()
    }

}