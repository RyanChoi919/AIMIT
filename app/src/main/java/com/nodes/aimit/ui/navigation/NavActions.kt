package com.nodes.aimit.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.nodes.aimit.R

object AimitNavRoutes {
    const val TODAY = "nav_route_today"
    const val GOALS = "nav_route_goals"
    const val SETTINGS = "nav_route_settings"
    const val ADD_MODIFY = "nav_route_add_modify"
    const val DETAIL = "nav_route_detail"
}

data class AimitTopLevelDestination(
    val route: String,
    val labelResId : Int,
    val icon: ImageVector
)

val TOP_LEVEL_DESTINATIONS = listOf(
    AimitTopLevelDestination(AimitNavRoutes.TODAY, R.string.destination_label_today, Icons.Default.DateRange),
    AimitTopLevelDestination(AimitNavRoutes.GOALS, R.string.destination_label_goals, Icons.Default.Star),
    AimitTopLevelDestination(AimitNavRoutes.SETTINGS, R.string.destination_label_settings, Icons.Default.Settings)
)

class NavActions(private val navController: NavHostController) {
    fun navigateTo(destination : AimitTopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}