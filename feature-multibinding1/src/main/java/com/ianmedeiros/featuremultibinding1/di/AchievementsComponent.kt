package com.ianmedeiros.featuremultibinding1.di

import com.ianmedeiros.featuremultibinding1.AchievementActivity
import com.ianmedeiros.featuremultibinding1.AchievementListActivity
import com.ianmedeiros.featuremultibinding1.domain.*
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.ElementsIntoSet

interface AchievementsComponent {
    val listComponent: AchievementListComponent
    val fragmentComponent: AchievementFragmentComponent.Factory
}

@Module
object AchievementsModule {

    @Provides
    @JvmStatic
    @ElementsIntoSet
    fun provideProtected(
        protected: ProtectedSpecification,
        rocketeer: RocketeerSpecification,
        alwaysClean: AlwaysCleanSpecification,
        suchSpeed: SuchSpeedSpecification
    ): Set<Achievement> = setOf(
        ThreeStepsAchievement(protected),
        ThreeStepsAchievement(rocketeer),
        ConsecutiveAchievement(alwaysClean),
        ConsecutiveAchievement(suchSpeed),
        VipAchievement()
    )

}

@Subcomponent(modules = [AchievementsModule::class])
interface AchievementListComponent {
    fun inject(activity: AchievementListActivity)
}

@Module
object AchievementFragmentModule {

    @Provides
    fun provideAchievement(type: AchievementsType, achievement: Set<@JvmSuppressWildcards Achievement>): Achievement =
        achievement.find { it.type == type }!!
}

@Subcomponent(modules = [AchievementsModule::class, AchievementFragmentModule::class])
interface AchievementFragmentComponent {
    fun inject(achievementActivity: AchievementActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance type: AchievementsType): AchievementFragmentComponent
    }
}