package com.mooncake.mydonuts.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.mooncake.mydonuts.ui.theme.MyDonutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDonutsTheme {
                Surface {
                    Test()
                }
            }
        }
    }
}

@Composable
fun Test() {
    var size by remember { mutableStateOf(IntSize.Zero) }
    val infiniteTransition = rememberInfiniteTransition()
    val x by infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = size.width.dp/2,
        typeConverter = Dp.Companion.VectorConverter,
        animationSpec = InfiniteRepeatableSpec(
            tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Row(
        Modifier
            .onSizeChanged { size = it }
            .fillMaxWidth()
    ) {
        Text(text = "Hi", Modifier.offset(x))
    }
}

@Preview
@Composable
fun Hi() {
    Test()
}