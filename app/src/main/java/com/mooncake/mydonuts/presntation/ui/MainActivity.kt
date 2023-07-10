package com.mooncake.mydonuts.presntation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mooncake.mydonuts.presntation.screens.OnboardScreen
import com.mooncake.mydonuts.presntation.ui.theme.MyDonutsTheme
import dagger.hilt.EntryPoint

@EntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDonutsTheme {
                OnboardScreen()
            }
        }
    }
}