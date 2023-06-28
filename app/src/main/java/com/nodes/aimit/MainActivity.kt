package com.nodes.aimit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nodes.aimit.ui.components.NavBar
import com.nodes.aimit.ui.screens.today.TodayScreen
import com.nodes.aimit.ui.theme.AIMITTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AIMITTheme {
                Main()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(modifier: Modifier = Modifier) {
    Scaffold(bottomBar = { NavBar() }) {
        TodayScreen(modifier.padding(it))
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    AIMITTheme {
        Main()
    }
}