package com.fitwise.domain.model

data class Workout(
    val id: String,
    val title: String,
    val totalDurationMinutes: Int,
    val exercises: List<Exercise>,
    val totalEstimatedCalories: Int
)
