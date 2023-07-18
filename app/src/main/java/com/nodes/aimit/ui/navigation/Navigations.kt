package com.nodes.aimit.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.nodes.aimit.domain.entity.AimitEntity

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AimitTopBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    selectedDestination: AimitDestination,
    aimitEntity: AimitEntity? = null
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = getTitleFromDestination(selectedDestination, aimitEntity))
        },
        navigationIcon = {
            if (!TOP_LEVEL_DESTINATIONS.map { it.destination }.contains(selectedDestination)) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }
        }
    )
}

private fun getTitleFromDestination(
    destination: AimitDestination,
    aimitEntity: AimitEntity? = null
): String {
    return when (destination) {
        AimitDestination.TODAY,
        AimitDestination.GOALS,
        AimitDestination.SETTINGS -> destination.name

        AimitDestination.ADD_MODIFY,
        AimitDestination.DETAIL -> aimitEntity?.name ?: ""
    }
}