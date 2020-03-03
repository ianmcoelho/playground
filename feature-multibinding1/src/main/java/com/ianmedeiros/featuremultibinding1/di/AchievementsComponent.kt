package com.ianmedeiros.featuremultibinding1.di

import com.ianmedeiros.featuremultibinding1.AchievementActivity
import com.ianmedeiros.featuremultibinding1.AchievementListActivity
import com.ianmedeiros.featuremultibinding1.domain.*
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet

interface AchievementsComponent {
    val listComponent: AchievementListComponent
    val fragmentComponent: AchievementFragmentComponent.Factory
}

@AssistedModule
@Module(includes = [AssistedInject_AchievementsModule::class])
object AchievementsModule {

    @Provides
    @JvmStatic
    @ElementsIntoSet
    fun provideThreeSteps(
        protected: ProtectedSpecification,
        rocketeer: RocketeerSpecification,
        factory: ThreeStepsAchievement.Factory
    ): Set<Achievement> = setOf(factory.create(protected), factory.create(rocketeer))

    @Provides
    @JvmStatic
    @ElementsIntoSet
    fun provideConsecutive(
        alwaysClean: AlwaysCleanSpecification,
        suchSpeed: SuchSpeedSpecification,
        factory: ConsecutiveAchievement.Factory
    ): Set<Achievement> = setOf(factory.create(alwaysClean), factory.create(suchSpeed))

    @Provides
    @JvmStatic
    @IntoSet
    fun provideVip(): Achievement = VipAchievement()

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