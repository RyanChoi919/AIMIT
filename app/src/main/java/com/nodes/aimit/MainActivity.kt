package com.nodes.aimit

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nodes.aimit.ui.screens.AddModifyScreen
import com.nodes.aimit.ui.screens.AimitAppScreen
import com.nodes.aimit.ui.theme.AIMITTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AIMITTheme {
                AimitAppScreen()
            }
        }
    }
}

@Preview
@Composable
private fun AimitAppPreview() {
    AIMITTheme {
        AimitAppScreen()
    }
}