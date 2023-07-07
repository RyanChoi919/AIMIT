package com.nodes.aimit.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nodes.aimit.ui.navigation.AimitNavBar
import com.nodes.aimit.ui.navigation.AimitNavRoutes
import com.nodes.aimit.ui.navigation.NavActions

@Composable
fun AimitAppScreen() {
    val navController = rememberNavController()
    val navActions = remember {
        NavActions(navController = navController)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination =
        navBackStackEntry?.destination?.route ?: AimitNavRoutes.TODAY

    Scaffold(bottomBar = { AimitNavBar(selectedDestination, navActions::navigateTo) }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            AimitNavHost(navController)
        }
    }
}

@Composable
private fun AimitNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = AimitNavRoutes.TODAY
    ) {
        composable(AimitNavRoutes.TODAY) {
            TodayScreen(modifier)
        }
        composable(AimitNavRoutes.GOALS) {
            GoalScreen(modifier)
        }
        composable(AimitNavRoutes.SETTINGS) {
            SettingsScreen(modifier)
        }
        composable(AimitNavRoutes.ADD_MODIFY) {
            AddModifyScreen(modifier)
        }
        composable(AimitNavRoutes.DETAIL) {
            DetailScreen(modifier)
        }
    }
}