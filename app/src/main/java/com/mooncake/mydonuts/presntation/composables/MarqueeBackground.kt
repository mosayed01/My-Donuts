package com.mooncake.mydonuts.presntation.composables

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mooncake.mydonuts.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MarqueeBackground(
    modifier: Modifier = Modifier,
    painter: Painter = painterResource(id = R.drawable.donuts)
) {
    val infiniteTransition = rememberInfiniteTransition()
    val yOffset by infiniteTransition.animateFloat(
        initialValue = 0.08f,
        targetValue = -0.07f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(8000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Row(
        modifier
            .fillMaxSize()
            .basicMarquee(
                iterations = Int.MAX_VALUE,
                initialDelayMillis = 0,
                delayMillis = 0,
                velocity = 15.dp,
            )
            .graphicsLayer { translationY = yOffset * size.height }
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxHeight(0.7f)
        )
    }
}