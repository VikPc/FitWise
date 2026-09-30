package com.fitwise.domain.model

enum class Difficulty { BEGINNER, INTERMEDIATE, ADVANCED }
enum class MuscleGroup { LEGS, CORE, UPPER_BODY, FULL_BODY, CARDIO }
enum class Equipment { NONE, DUMBBELLS, MAT }

data class Exercise(
    val id: String,
    val name: String,
    val description: String,
    val muscleGroup: MuscleGroup,
    val difficulty: Difficulty,
    val equipment: Equipment = Equipment.NONE,
    val durationSeconds: Int = 45,
    val estimatedCalories: Int = 10
)
