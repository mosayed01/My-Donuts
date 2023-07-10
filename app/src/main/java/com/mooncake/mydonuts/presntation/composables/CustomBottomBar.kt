package com.mooncake.mydonuts.presntation.composables

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mooncake.mydonuts.R
import com.mooncake.mydonuts.presntation.ui.theme.LocalNavController
import com.mooncake.mydonuts.presntation.ui.theme.Pink

@Composable
fun CustomBottomBar() {
    val navController = LocalNavController.current
    val entry by navController.currentBackStackEntryAsState()
    val screens = listOf(
        BottomBarDataItem("HOME", R.drawable.ic_home_filled, R.drawable.ic_home_outline),
        BottomBarDataItem("FAVOURITE", R.drawable.ic_fav_filled, R.drawable.ic_fav_outlined),
        BottomBarDataItem(
            "NOTIFICATION",
            R.drawable.ic_notification_filled,
            R.drawable.ic_notification_outlined
        ),
        BottomBarDataItem("BUY", R.drawable.ic_buy_filled, R.drawable.ic_buy_outlined),
        BottomBarDataItem("USER", R.drawable.ic_user_filled, R.drawable.ic_user_outlined),
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 0.dp
    ) {
        screens.forEach {
            BottomBarItem(
                item = it,
                navController = navController,
                currentDestination = entry?.destination
            )
        }
    }
}

@Composable
fun RowScope.BottomBarItem(
    item: BottomBarDataItem,
    navController: NavController,
    currentDestination: NavDestination?,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
    BottomNavigationItem(
        selected = selected,
        onClick = {
            navController.navigate(item.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        icon = {
            Crossfade(targetState = selected) {
                Icon(
                    painter = painterResource(id = if (it) item.selectedIcon else item.unSelectedIcon),
                    contentDescription = "icon",
                    tint = Pink
                )
            }
        },
    )
}

data class BottomBarDataItem(
    val route: String,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
)