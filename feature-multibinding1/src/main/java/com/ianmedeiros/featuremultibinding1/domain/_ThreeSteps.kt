package com.ianmedeiros.featuremultibinding1.domain

import com.ianmedeiros.corecontracts.FeatureTracking
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import javax.inject.Inject

interface ThreeStepsSpecification {
    val type: AchievementsType.ThreeSteps
}

class ProtectedSpecification @Inject constructor() : ThreeStepsSpecification {
    override val type = AchievementsType.ThreeSteps.Protected
}

class RocketeerSpecification @Inject constructor() : ThreeStepsSpecification {
    override val type = AchievementsType.ThreeSteps.Rocketeer
}

class ThreeStepsAchievement @AssistedInject constructor(
    @Assisted private val specification: ThreeStepsSpecification,
    private val tracking: FeatureTracking
) : Achievement {

    override val type: AchievementsType.ThreeSteps
        get() {
            tracking.onEvent(specification.type.toString())
            return specification.type
        }

    @AssistedInject.Factory
    interface Factory {
        fun create(specification: ThreeStepsSpecification): ThreeStepsAchievement
    }

}