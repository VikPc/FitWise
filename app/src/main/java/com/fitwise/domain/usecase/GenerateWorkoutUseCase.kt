package com.fitwise.domain.usecase

import com.fitwise.domain.model.UserProfile
import com.fitwise.domain.model.Workout
import com.fitwise.domain.repository.ExerciseRepository

class GenerateWorkoutUseCase(
    private val exerciseRepository: ExerciseRepository
) {
    operator fun invoke(profile: UserProfile): Workout {
        val availableExercises = exerciseRepository.getAllExercises()
            .filter { it.difficulty <= profile.level }

        // Seleccionamos un número de ejercicios adecuado para el tiempo
        val count = when {
            profile.availableMinutes <= 5 -> 3
            profile.availableMinutes <= 10 -> 5
            else -> 7
        }

        val selectedExercises = availableExercises.shuffled().take(count)
        val estimatedCalories = selectedExercises.sumOf { it.estimatedCalories } * (profile.availableMinutes / 5).coerceAtLeast(1)

        return Workout(
            id = "workout_",
            title = "Rutina Express de  min",
            totalDurationMinutes = profile.availableMinutes,
            exercises = selectedExercises,
            totalEstimatedCalories = estimatedCalories
        )
    }
}
