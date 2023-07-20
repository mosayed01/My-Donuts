package com.mooncake.mydonuts.presntation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mooncake.mydonuts.R
import com.mooncake.mydonuts.presntation.composables.ButtonHasText
import com.mooncake.mydonuts.presntation.composables.MarqueeBackground
import com.mooncake.mydonuts.presntation.navigation.navigateToHome
import com.mooncake.mydonuts.presntation.ui.theme.LocalNavController
import com.mooncake.mydonuts.presntation.ui.theme.LocalSystemUiController
import com.mooncake.mydonuts.presntation.ui.theme.MyDonutsTheme
import com.mooncake.mydonuts.presntation.ui.theme.Pink
import com.mooncake.mydonuts.presntation.ui.theme.PinkLight
import com.mooncake.mydonuts.presntation.ui.theme.PinkMedium

@Composable
fun OnboardScreen() {
    val systemUiController = LocalSystemUiController.current
    val navController = LocalNavController.current
    SideEffect {
        systemUiController.isSystemBarsVisible = false
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkLight)
    ) {
        MarqueeBackground()
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 40.dp),
        ) {
            Text(
                text = stringResource(R.string.gonuts_with_donuts),
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(bottom = 16.dp),
                color = Pink
            )
            Text(
                text = stringResource(R.string.onboard_caption),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 60.dp),
                color = PinkMedium
            )
            ButtonHasText(
                text = stringResource(R.string.get_started),
                onClick = { navController.navigateToHome() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
        }
    }
}


@Preview
@Composable
private fun Preview() {
    MyDonutsTheme {
        OnboardScreen()
    }
}
