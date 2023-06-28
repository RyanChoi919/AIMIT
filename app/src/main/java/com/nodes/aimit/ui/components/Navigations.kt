package com.nodes.aimit.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector

private val navBarItems = listOf(
    NavBarItem("Today", Icons.Rounded.Home),
    NavBarItem("Goal", Icons.Rounded.Star),
    NavBarItem("Settings", Icons.Rounded.Settings)
)

@Composable
fun NavBar() {
    var selectedIndex by rememberSaveable { mutableStateOf(0) }

    NavigationBar() {
        navBarItems.forEachIndexed { index, navBarItem ->
            NavigationBarItem(
                selected = index == selectedIndex,
                onClick = { /*TODO*/ },
                label = { Text(navBarItem.name) },
                icon = {
                    Image(
                        imageVector = navBarItem.icon,
                        contentDescription = "${navBarItem.name} icon"
                    )
                })
        }
    }
}

data class NavBarItem(
    val name: String,
    val icon: ImageVector
)