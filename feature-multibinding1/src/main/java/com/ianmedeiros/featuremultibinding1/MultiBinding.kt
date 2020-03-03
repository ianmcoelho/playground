package com.ianmedeiros.featuremultibinding1

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.IntoSet
import javax.inject.Inject

/**
 * ThreeSteps specs
 */
interface ThreeStepsSpecification {
    val threeStepsText: String
}

class ProtectedSpecification @Inject constructor() : ThreeStepsSpecification {
    override val threeStepsText: String
        get() = "Protected"
}

class RocketeerSpecification @Inject constructor() : ThreeStepsSpecification {
    override val threeStepsText: String
        get() = "Rocketeer"
}

/**
 *  Consecutive Specs
 */
interface ConsecutiveSpecification {
    val consecutiveText: String
}

class AlwaysCleanSpecification @Inject constructor() : ConsecutiveSpecification {
    override val consecutiveText: String
        get() = "Always Clean"
}

class SuchSpeedSpecification @Inject constructor() : ConsecutiveSpecification {
    override val consecutiveText: String
        get() = "Such Speed"
}

/**
 * Achievements
 */
interface Achievement {
    val text: String
}

class ThreeStepsAchievement @Inject constructor(private val specification: ThreeStepsSpecification) : Achievement {

    override val text: String
        get() = specification.threeStepsText

}

class ConsecutiveAchievement @Inject constructor(private val specification: ConsecutiveSpecification) : Achievement {

    override val text: String
        get() = specification.consecutiveText
}

class VipAchievement : Achievement {
    override val text: String
        get() = "Vip"
}

/**
 * UseCase
 */

class AchievementUseCase @Inject constructor(private val achievement: Achievement) {
    val text get() = achievement.text
}

class AchievementViewModel @Inject constructor(private val useCase: AchievementUseCase) {

    val text get() = useCase.text

}

class ListAchievementsUseCase @Inject constructor(val achievementList: Set<@JvmSuppressWildcards Achievement>)

interface ViewModelModule

@Module
abstract class ProtectedModule {

    @Binds
    abstract fun bindsSpec(spec: ThreeStepsSpecification): ThreeStepsSpecification

    @Binds
    abstract fun bindAchievement(ach: Achievement): Achievement

}

@Module
object AchievementsModule {

    @Provides
    @JvmStatic
    @IntoSet
    fun provideProtected(protected: ProtectedSpecification): Achievement = ThreeStepsAchievement(protected)

    @Provides
    @JvmStatic
    @IntoSet
    fun provideConsecutiveSpecs(alwaysClean: AlwaysCleanSpecification): Achievement = ConsecutiveAchievement(alwaysClean)

}

@Subcomponent(modules = [AchievementsModule::class])
interface ViewModelComponent {

    val achievements: Set<Achievement>

//    fun inject(activity: AchievementActivity)
    fun inject(activity: MultibindingActivity)
}