package com.ianmedeiros.featuremultibinding1.domain

sealed class AchievementsType {
    sealed class ConsecutiveUse : AchievementsType() {
        object AlwaysClean : ConsecutiveUse()
        object SuchSpeed : ConsecutiveUse()

        companion object {
            val values
                get() = arrayOf(
                    AlwaysClean,
                    SuchSpeed
                )
        }
    }

    sealed class ThreeSteps : AchievementsType() {
        object Protected : ThreeSteps()
        object Rocketeer : ThreeSteps()

        companion object {
            val values
                get() = arrayOf(
                    Protected,
                    Rocketeer
                )
        }
    }

    object Vip : AchievementsType()

    override fun toString() = when (this) {
        ConsecutiveUse.AlwaysClean -> ALWAYS_CLEAN
        ConsecutiveUse.SuchSpeed -> SUCH_SPEED
        ThreeSteps.Protected -> PROTECTED
        ThreeSteps.Rocketeer -> ROCKETEER
        Vip -> VIP
    }

    companion object {
        private const val ALWAYS_CLEAN = "alwaysclean"
        private const val SUCH_SPEED = "suchspeed"
        private const val PROTECTED = "protected"
        private const val ROCKETEER = "rocketeer"
        private const val VIP = "vip"

        fun fromString(string: String) = when (string) {
            ALWAYS_CLEAN -> ConsecutiveUse.AlwaysClean
            SUCH_SPEED -> ConsecutiveUse.SuchSpeed
            PROTECTED -> ThreeSteps.Protected
            ROCKETEER -> ThreeSteps.Rocketeer
            VIP -> Vip
            else -> throw IllegalArgumentException("String cannot be converted to achievements type")
        }

        val values
            get() = arrayOf(
                *ConsecutiveUse.values,
                *ThreeSteps.values,
                Vip
            )
    }
}