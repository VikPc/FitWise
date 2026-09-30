package com.fitwise.presentation.home

import androidx.lifecycle.ViewModel
import com.fitwise.data.repository.LocalExerciseRepository
import com.fitwise.domain.model.Difficulty
import com.fitwise.domain.model.FitnessGoal
import com.fitwise.domain.model.UserProfile
import com.fitwise.domain.model.Workout
import com.fitwise.domain.usecase.GenerateWorkoutUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomeUiState(
    val selectedMinutes: Int = 10,
    val selectedLevel: Difficulty = Difficulty.BEGINNER,
    val selectedGoal: FitnessGoal = FitnessGoal.FITNESS,
    val generatedWorkout: Workout? = null,
    val isLoading: Boolean = false
)

class HomeViewModel : ViewModel() {
    private val repository = LocalExerciseRepository()
    private val generateWorkoutUseCase = GenerateWorkoutUseCase(repository)

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        generateWorkout()
    }

    fun onTimeSelected(minutes: Int) {
        _uiState.value = _uiState.value.copy(selectedMinutes = minutes)
        generateWorkout()
    }

    fun onLevelSelected(level: Difficulty) {
        _uiState.value = _uiState.value.copy(selectedLevel = level)
        generateWorkout()
    }

    fun generateWorkout() {
        val currentState = _uiState.value
        val profile = UserProfile(
            availableMinutes = currentState.selectedMinutes,
            level = currentState.selectedLevel,
            goal = currentState.selectedGoal
        )
        val workout = generateWorkoutUseCase(profile)
        _uiState.value = currentState.copy(generatedWorkout = workout)
    }
}
