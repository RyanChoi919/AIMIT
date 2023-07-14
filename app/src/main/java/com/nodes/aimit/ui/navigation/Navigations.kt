package com.nodes.aimit.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun AimitNavBar(
    selectedDestination: String,
    navigateToTopLevelDestination: (AimitTopLevelDestination) -> Unit
) {
    NavigationBar() {
        TOP_LEVEL_DESTINATIONS.forEach {
            NavigationBarItem(
                selected = selectedDestination == it.destination.route,
                onClick = { navigateToTopLevelDestination(it) },
                label = { Text(stringResource(id = it.labelResId)) },
                icon = {
                    Image(
                        imageVector = it.icon,
                        contentDescription = "${stringResource(id = it.labelResId)} icon"
                    )
                })
        }
    }
}