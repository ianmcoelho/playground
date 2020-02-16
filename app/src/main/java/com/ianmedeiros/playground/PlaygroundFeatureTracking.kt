package com.ianmedeiros.playground

import com.ianmedeiros.corecontracts.FeatureTracking
import com.ianmedeiros.coremodule.extensions.logd
import javax.inject.Inject

class PlaygroundFeatureTracking @Inject constructor() : FeatureTracking {

    override fun onEvent(event: String) {
        logd { event }
    }
}