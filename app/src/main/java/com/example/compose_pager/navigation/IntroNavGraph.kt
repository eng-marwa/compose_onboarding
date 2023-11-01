package com.example.compose_pager.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.compose_pager.presentation.OnboardingPager
import com.example.compose_pager.presentation.Splash

//
//fun NavGraphBuilder.introNavGraph(navController: NavController){
//
//    navigation(startDestination = NavigationItem.Splash.route, route = NavigationItem.IntroNavGraph.route){
//        composable(NavigationItem.Splash.route){
//            Splash(navController = navController)
//        }
//        composable(NavigationItem.Onboarding.route){
//            OnboardingPager(navController = navController)
//        }
//    }
//}