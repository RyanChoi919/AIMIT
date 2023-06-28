package com.nodes.aimit.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nodes.aimit.ui.theme.AIMITTheme

private val defaultInnerPadding = 16.dp
private val defaultOuterHorizontalPadding = 16.dp
private val defaultOuterVerticalPadding = 4.dp

@Composable
private fun ListCard(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = defaultOuterHorizontalPadding, vertical = defaultOuterVerticalPadding
            ), content = content
    )
}

@Composable
fun GoalListItem(name: String) {
    ListCard() {
        Text(name, Modifier.padding(defaultInnerPadding))
    }
}

@Composable
fun HabitListItem() {
    ListCard() {
        Text("Habit List Item", Modifier.padding(defaultInnerPadding))
    }
}

@Composable
fun RoutineListItem() {
    ListCard() {
        Text("Routine List Item", Modifier.padding(defaultInnerPadding))
    }
}

@Composable
fun TaskListItem() {
    ListCard() {
        Text("Task List Item", Modifier.padding(defaultInnerPadding))
    }
}

@Preview
@Composable
private fun GoalListItemPreview() {
    AIMITTheme {
        GoalListItem("Goal List")
    }
}

@Preview
@Composable
private fun HabitListItemPreview() {
    AIMITTheme {
        HabitListItem()
    }
}

@Preview
@Composable
private fun RoutineListItemPreview() {
    AIMITTheme {
        RoutineListItem()
    }
}

@Preview
@Composable
private fun TaskListItemPreview() {
    AIMITTheme {
        TaskListItem()
    }
}