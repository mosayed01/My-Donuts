package com.mooncake.mydonuts.presntation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mooncake.mydonuts.presntation.ui.theme.LocalNavController

@Composable
fun MyDonutsNavGraph() {
    val navController = LocalNavController.current
    NavHost(
        navController = navController as NavHostController,
        startDestination = START_DESTINATION_ROUTE
    ) {
        onboardRoute()
        homeRoute()
        donutsDetailsRoute()
    }
}