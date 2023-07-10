package com.mooncake.mydonuts.presntation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mooncake.mydonuts.presntation.screens.home.HomeScreen

private const val ROUTE = "HOME"
fun NavGraphBuilder.homeRoute() {
    composable(route = ROUTE) { HomeScreen() }
}

fun NavController.navigateToHome() {
    navigate(ROUTE){
        popBackStack()
    }
}