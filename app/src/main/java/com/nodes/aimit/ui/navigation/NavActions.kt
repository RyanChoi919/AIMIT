package com.nodes.aimit.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.nodes.aimit.R

enum class AimitDestination(
    val route: String, val shouldShowFab: Boolean = false, val shouldShowBnv: Boolean = true
) {
    TODAY(
        "nav_route_today",
        true
    ),
    GOALS("nav_route_goals"), SETTINGS("nav_route_settings"), ADD_MODIFY(
        "nav_route_add_modify",
        shouldShowBnv = false
    ),
    DETAIL("nav_route_detail", shouldShowBnv = false);


    companion object {
        fun getDestinationByRoute(route: String?): AimitDestination? {
            return route?.let { AimitDestination.values().find { it.route == route } }
        }
    }
}

data class AimitTopLevelDestination(
    val destination: AimitDestination, val labelResId: Int, val icon: ImageVector
)

val TOP_LEVEL_DESTINATIONS = listOf(
    AimitTopLevelDestination(
        AimitDestination.TODAY, R.string.destination_label_today, Icons.Default.DateRange
    ), AimitTopLevelDestination(
        AimitDestination.GOALS, R.string.destination_label_goals, Icons.Default.Star
    ), AimitTopLevelDestination(
        AimitDestination.SETTINGS, R.string.destination_label_settings, Icons.Default.Settings
    )
)

class NavActions(private val navController: NavHostController) {
    fun navigateTo(destination: AimitDestination) {
        navController.navigate(destination.route)
    }

    fun navigateTo(destination: AimitTopLevelDestination) {
        navController.navigate(destination.destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}