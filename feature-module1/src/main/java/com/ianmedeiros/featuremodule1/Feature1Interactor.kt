package com.ianmedeiros.featuremodule1

import com.ianmedeiros.corecontracts.FeatureContent
import com.ianmedeiros.corecontracts.FeatureInteractor
import com.ianmedeiros.corecontracts.FeatureTracking
import com.ianmedeiros.corecontracts.ON_LOAD_CONTENT
import javax.inject.Inject

class Feature1Interactor @Inject constructor(
    private val tracking: FeatureTracking
) : FeatureInteractor {

    override suspend fun loadFeatureContent(): FeatureContent {
        tracking.onEvent(ON_LOAD_CONTENT)
        return FeatureContent("Feature 1 String")
    }

}