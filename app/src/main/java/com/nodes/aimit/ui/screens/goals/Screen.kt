package com.nodes.aimit.ui.screens.goals

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nodes.aimit.ui.components.GoalListItem
import com.nodes.aimit.ui.theme.AIMITTheme

@Composable
fun GoalScreen(modifier: Modifier = Modifier) {

    val goals: List<String> = List(1000) { "Goal" }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(Modifier.padding(4.dp)) {
            itemsIndexed(items = goals) { index, goal ->
                GoalListItem(name = "$goal $index")
            }
        }
    }
}

@Preview
@Composable
private fun GoalScreenPreview() {
    AIMITTheme {
        GoalScreen()
    }
}