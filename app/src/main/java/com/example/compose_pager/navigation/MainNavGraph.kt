package com.example.compose_pager.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.compose_pager.presentation.HomeScreen
import com.example.compose_pager.presentation.Splash

fun NavGraphBuilder.mainNavGraph(navController: NavController){

    navigation(startDestination = NavigationItem.Home.route, route = NavigationItem.MainNavGraph.route){
        composable(NavigationItem.Home.route){
            HomeScreen(navController = navController)
        }

    }
}