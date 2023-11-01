package com.example.compose_pager.navigation

enum class Screen{
    SPLASH,ON_BOARDING,INTRO,HOME,MAIN
}

sealed class NavigationItem(val route: String) {
    data object Splash : NavigationItem(Screen.SPLASH.name)
    data object Onboarding : NavigationItem(Screen.ON_BOARDING.name)
    data object Home : NavigationItem(Screen.HOME.name)
    data object IntroNavGraph : NavigationItem(Screen.INTRO.name)
    data object MainNavGraph : NavigationItem(Screen.MAIN.name)

}