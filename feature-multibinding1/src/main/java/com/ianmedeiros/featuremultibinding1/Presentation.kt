package com.ianmedeiros.featuremultibinding1

import com.ianmedeiros.featuremultibinding1.domain.Achievement
import javax.inject.Inject

class ListAchievementsUseCase @Inject constructor(val achievementList: Set<@JvmSuppressWildcards Achievement>)

class AchievementUseCase @Inject constructor(private val achievement: Achievement) {
    val text get() = achievement.type.toString()
}

class AchievementViewModel @Inject constructor(private val useCase: AchievementUseCase) {

    val text get() = useCase.text

}