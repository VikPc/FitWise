package com.fitwise.domain.repository

import com.fitwise.domain.model.Exercise

interface ExerciseRepository {
    fun getAllExercises(): List<Exercise>
}
