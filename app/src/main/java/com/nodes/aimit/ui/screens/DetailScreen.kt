package com.nodes.aimit.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nodes.aimit.domain.model.ContentType
import com.nodes.aimit.ui.theme.AIMITTheme

@Composable
fun DetailScreen(modifier: Modifier = Modifier, contentType: ContentType = ContentType.GOAL) {
    when (contentType) {
        ContentType.GOAL -> DetailGoalContent(modifier = modifier)
        ContentType.HABIT -> DetailHabitContent(modifier = modifier)
        ContentType.ROUTINE -> DetailRoutineContent(modifier = modifier)
        ContentType.TASK -> DetailTaskContent(modifier = modifier)
    }
}

@Composable
private fun DetailGoalContent(modifier: Modifier = Modifier) {

    var text by rememberSaveable { mutableStateOf("") }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row() {
            Text(text = "Detail Goal Screen")
            TextField(value = text, onValueChange = { text = it })
        }
    }
}

@Composable
private fun DetailHabitContent(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row() {
            Text(text = "Detail Habit Screen")
        }
    }
}

@Composable
private fun DetailRoutineContent(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row() {
            Text(text = "Detail Routine Screen")
        }
    }
}

@Composable
private fun DetailTaskContent(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row() {
            Text(text = "Detail Task Screen")
        }
    }
}

@Preview
@Composable
private fun DetailGoalScreenPreview() {
    AIMITTheme() {
        DetailScreen(contentType = ContentType.GOAL)
    }
}