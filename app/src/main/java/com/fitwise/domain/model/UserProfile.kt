package com.fitwise.domain.model

enum class FitnessGoal { FAT_LOSS, FITNESS, STRENGTH, MOBILITY }

data class UserProfile(
    val id: String = "user_default",
    val availableMinutes: Int = 10,
    val goal: FitnessGoal = FitnessGoal.FITNESS,
    val level: Difficulty = Difficulty.BEGINNER,
    val equipment: Equipment = Equipment.NONE
)
