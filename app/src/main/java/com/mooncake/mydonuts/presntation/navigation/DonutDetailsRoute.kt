package com.mooncake.mydonuts.presntation.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mooncake.mydonuts.presntation.navigation.DonutDetailsArgs.Companion.DONUT_ID
import com.mooncake.mydonuts.presntation.screens.donuts_details.DonutsDetailsScreen
import javax.inject.Inject
import javax.inject.Singleton

private const val ROUTE = "DONUT_DETAILS"
fun NavGraphBuilder.donutsDetails(){
    composable(
        route = "$ROUTE/{$DONUT_ID}",
        arguments = listOf(
            navArgument(DONUT_ID){ type = NavType.IntType }
        )
    ){
        DonutsDetailsScreen()
    }
}

@Singleton
class DonutDetailsArgs @Inject constructor(savedStateHandle: SavedStateHandle){
    val donutId: Int = savedStateHandle.get<Int>(DONUT_ID) ?: 0

    companion object {
        const val DONUT_ID = "donut_id"
    }
}

fun NavController.navigateToDonutDetails(donutId: Int){
    navigate("$ROUTE/$donutId")
}