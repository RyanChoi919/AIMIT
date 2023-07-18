package com.nodes.aimit.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nodes.aimit.ui.navigation.AimitDestination
import com.nodes.aimit.ui.navigation.AimitNavBar
import com.nodes.aimit.ui.navigation.AimitTopBar
import com.nodes.aimit.ui.navigation.NavActions
import com.nodes.aimit.ui.theme.AIMITTheme

const val TAG = "LOG_TAG : "

@Composable
fun AimitAppScreen() {
    val navController = rememberNavController()
    val navActions = remember {
        NavActions(navController = navController)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val selectedDestination = AimitDestination.getDestinationByRoute(
        navBackStackEntry?.destination?.route
    ) ?: AimitDestination.TODAY

    Log.d(TAG, "AimitAppScreen: ${selectedDestination.route}")

    Scaffold(
        topBar = {
            AimitTopBar(
                selectedDestination = selectedDestination,
                navController = navController
            )
        },
        bottomBar = {
            if (selectedDestination.shouldShowBnv) {
                AimitNavBar(selectedDestination.route, navActions::navigateTo)
            }
        }, floatingActionButton = {
            if (selectedDestination.shouldShowFab) {
                FloatingActionButton(onClick = { navActions.navigateTo(AimitDestination.ADD_MODIFY) }) {
                    Icon(
                        imageVector = Icons.Default.Add, contentDescription = null
                    )
                }
            }
        }, floatingActionButtonPosition = FabPosition.End
    ) {
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
    navController: NavHostController, modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = AimitDestination.TODAY.route
    ) {
        composable(AimitDestination.TODAY.route) {
            TodayScreen(modifier)
        }
        composable(AimitDestination.GOALS.route) {
            GoalScreen(modifier)
        }
        composable(AimitDestination.SETTINGS.route) {
            SettingsScreen(modifier)
        }
        composable(AimitDestination.ADD_MODIFY.route) {
            AddModifyScreen(modifier)
        }
        composable(AimitDestination.DETAIL.route) {
            DetailScreen(modifier)
        }
    }
}


@Preview
@Composable
private fun AimitAppScreenPreview() {
    AIMITTheme {
        AimitAppScreen()
    }
}