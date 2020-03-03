package com.ianmedeiros.featuremultibinding1.domain

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

class ConsecutiveAchievement @Inject constructor(specification: ConsecutiveSpecification) :
    Achievement {

    override val type: AchievementsType = specification.type
}