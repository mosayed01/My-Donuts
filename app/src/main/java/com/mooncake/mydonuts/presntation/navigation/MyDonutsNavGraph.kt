package com.mooncake.mydonuts.presntation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mooncake.mydonuts.presntation.composables.CustomBottomBar
import com.mooncake.mydonuts.presntation.screens.dumy.DummyScreen
import com.mooncake.mydonuts.presntation.ui.theme.LocalNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDonutsNavGraph() {
    val navController = LocalNavController.current
    val entry by navController.currentBackStackEntryAsState()
    val currentRoute = entry?.destination?.route ?: START_DESTINATION_ROUTE
    Scaffold(bottomBar = {
        AnimatedVisibility(
            visible = !(currentRoute == START_DESTINATION_ROUTE || currentRoute == "DONUT_DETAILS/{donut_id}"),
            enter = slideInVertically(initialOffsetY = { it }, animationSpec = tween(300)),
            exit = slideOutVertically(targetOffsetY = { it }, animationSpec = tween(300)),
        ) { CustomBottomBar() }
    }) {
        NavHost(
            navController = navController as NavHostController,
            startDestination = START_DESTINATION_ROUTE,
            modifier = Modifier.padding(it)
        ) {
            onboardRoute()
            homeRoute()
            donutsDetailsRoute()

            // region dummy
            composable("FAVOURITE") { DummyScreen() }
            composable("NOTIFICATION") { DummyScreen() }
            composable("BUY") { DummyScreen() }
            composable("USER") { DummyScreen() }
            // endregion
        }
    }
}