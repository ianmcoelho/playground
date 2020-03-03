package com.ianmedeiros.featuremultibinding1.domain

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

class ThreeStepsAchievement @Inject constructor(specification: ThreeStepsSpecification) :
    Achievement {

    override val type = specification.type

}