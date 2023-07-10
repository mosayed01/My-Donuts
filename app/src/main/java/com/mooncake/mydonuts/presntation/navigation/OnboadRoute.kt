package com.mooncake.mydonuts.presntation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mooncake.mydonuts.presntation.screens.OnboardScreen

const val START_DESTINATION_ROUTE = "ONBOARD"
fun NavGraphBuilder.onboardRoute() {
    composable(route = START_DESTINATION_ROUTE) { OnboardScreen() }
}