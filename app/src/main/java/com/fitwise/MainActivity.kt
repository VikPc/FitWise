package com.fitwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.fitwise.presentation.auth.LoginScreen
import com.fitwise.presentation.auth.OnboardingScreen
import com.fitwise.presentation.auth.RegisterScreen
import com.fitwise.presentation.home.HomeScreen
import com.fitwise.ui.theme.FitWiseTheme

enum class Screen { LOGIN, REGISTER, ONBOARDING, HOME }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitWiseTheme {
                var currentScreen by remember { mutableStateOf(Screen.LOGIN) }

                when (currentScreen) {
                    Screen.LOGIN -> LoginScreen(
                        onLoginSuccess = { currentScreen = Screen.HOME },
                        onNavigateToRegister = { currentScreen = Screen.REGISTER }
                    )
                    Screen.REGISTER -> RegisterScreen(
                        onRegisterSuccess = { currentScreen = Screen.ONBOARDING },
                        onNavigateToLogin = { currentScreen = Screen.LOGIN }
                    )
                    Screen.ONBOARDING -> OnboardingScreen(
                        onComplete = { currentScreen = Screen.HOME },
                        onBack = { currentScreen = Screen.REGISTER }
                    )
                    Screen.HOME -> HomeScreen()
                }
            }
        }
    }
}
