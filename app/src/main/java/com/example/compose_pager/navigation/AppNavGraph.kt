package com.example.compose_pager.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose_pager.presentation.OnboardingPager
import com.example.compose_pager.presentation.Splash

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Splash.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationItem.Splash.route) {
            Splash(navController = navController)
        }
        composable(NavigationItem.Onboarding.route) {
            OnboardingPager(navController = navController)
        }
        mainNavGraph(navController)

    }
}