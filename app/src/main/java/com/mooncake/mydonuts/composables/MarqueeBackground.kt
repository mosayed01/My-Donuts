package com.mooncake.mydonuts.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Row(
        modifier
            .fillMaxWidth()
            .basicMarquee(
                iterations = Int.MAX_VALUE,
                initialDelayMillis = 0,
                delayMillis = 0,
                velocity = 100.dp,
            )
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxHeight(0.7f)
        )
    }
}