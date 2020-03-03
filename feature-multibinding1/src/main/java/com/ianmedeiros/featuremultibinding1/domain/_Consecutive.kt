package com.ianmedeiros.featuremultibinding1.domain

import com.ianmedeiros.corecontracts.FeatureTracking
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import javax.inject.Inject

interface ConsecutiveSpecification {
    val type: AchievementsType.ConsecutiveUse
}

class AlwaysCleanSpecification @Inject constructor() : ConsecutiveSpecification {
    override val type = AchievementsType.ConsecutiveUse.AlwaysClean
}

class SuchSpeedSpecification @Inject constructor() : ConsecutiveSpecification {
    override val type = AchievementsType.ConsecutiveUse.SuchSpeed
}

class ConsecutiveAchievement @AssistedInject constructor(
    @Assisted private val specification: ConsecutiveSpecification,
    private val tracking: FeatureTracking
) : Achievement {

    override val type: AchievementsType
        get() {
            tracking.onEvent(specification.type.toString())
            return specification.type
        }

    @AssistedInject.Factory
    interface Factory {
        fun create(specification: ConsecutiveSpecification): ConsecutiveAchievement
    }
}