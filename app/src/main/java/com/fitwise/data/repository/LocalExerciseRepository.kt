package com.fitwise.data.repository

import com.fitwise.domain.model.Difficulty
import com.fitwise.domain.model.Equipment
import com.fitwise.domain.model.Exercise
import com.fitwise.domain.model.MuscleGroup
import com.fitwise.domain.repository.ExerciseRepository

class LocalExerciseRepository : ExerciseRepository {
    override fun getAllExercises(): List<Exercise> {
        return listOf(
            Exercise("1", "Sentadillas", "Sentadillas libres con peso corporal", MuscleGroup.LEGS, Difficulty.BEGINNER, Equipment.NONE, 45, 8),
            Exercise("2", "Flexiones de Brazo", "Flexiones estándar en suelo o rodillas", MuscleGroup.UPPER_BODY, Difficulty.BEGINNER, Equipment.NONE, 45, 10),
            Exercise("3", "Plancha Abdominal", "Isométrico para zona media", MuscleGroup.CORE, Difficulty.BEGINNER, Equipment.NONE, 30, 5),
            Exercise("4", "Jumping Jacks", "Saltos con tijera para elevar pulso", MuscleGroup.CARDIO, Difficulty.BEGINNER, Equipment.NONE, 45, 12),
            Exercise("5", "Zancadas / Lunges", "Zancadas alternadas paso a paso", MuscleGroup.LEGS, Difficulty.INTERMEDIATE, Equipment.NONE, 45, 9),
            Exercise("6", "Burpees", "Movimiento metabólico completo", MuscleGroup.CARDIO, Difficulty.INTERMEDIATE, Equipment.NONE, 45, 15),
            Exercise("7", "Escaladores (Mountain Climbers)", "Cardio enfocado en abdomen y hombros", MuscleGroup.CARDIO, Difficulty.BEGINNER, Equipment.NONE, 45, 11),
            Exercise("8", "Fondos de Tríceps en Silla", "Extensiones utilizando apoyo estable", MuscleGroup.UPPER_BODY, Difficulty.BEGINNER, Equipment.NONE, 45, 8)
        )
    }
}
