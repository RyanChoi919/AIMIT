package com.nodes.aimit.ui.screens.addmodify.routine

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nodes.aimit.ui.screens.today.TodayScreen
import com.nodes.aimit.ui.theme.AIMITTheme

@Composable
fun AddModifyRoutineScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row() {
            Text("Add Modify Routine Screen")
        }
    }
}

@Preview
@Composable
private fun AddModifyRoutineScreenPreview() {
    AIMITTheme() {
        AddModifyRoutineScreen()
    }
}