package com.ianmedeiros.corecontracts

data class FeatureContent(val text: String)

interface FeatureInteractor {

    suspend fun loadFeatureContent(): FeatureContent

}

interface FeatureTracking {
    fun onEvent(event: String)
}

const val ON_LOAD_CONTENT = "ON_LOAD_CONTENT"