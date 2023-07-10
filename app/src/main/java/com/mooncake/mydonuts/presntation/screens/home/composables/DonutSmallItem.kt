package com.mooncake.mydonuts.presntation.screens.home.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mooncake.mydonuts.R
import com.mooncake.mydonuts.presntation.screens.home.Donut
import com.mooncake.mydonuts.presntation.ui.theme.Black60
import com.mooncake.mydonuts.presntation.ui.theme.MyDonutsTheme
import com.mooncake.mydonuts.presntation.ui.theme.Pink
import com.mooncake.mydonuts.presntation.ui.theme.White

@Composable
fun DonutSmallItem(
    onClick: (Int) -> Unit,
    donut: Donut,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(targetValue = if (isPressed) 0.85f else 1f)

    Box(modifier = modifier
        .height(150.dp)
        .clickable(interactionSource, null) { onClick(donut.id) }
        .scale(scale)
    ) {
        Column(
            modifier = Modifier
                .size(130.dp, 110.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                )
                .background(White)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(
                text = donut.name,
                style = MaterialTheme.typography.bodyMedium.copy(color = Black60),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "$${donut.finalPrice}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Pink,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        Image(
            painter = painterResource(id = donut.image),
            contentDescription = "${donut.name} image",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(75.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview() {
    val donut = Donut(
        id = 1,
        image = R.drawable.small_chocolate_cherry,
        name = "Chocolate Glaze",
        finalPrice = 22,
    )
    MyDonutsTheme {
        LazyRow(
            Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(8) {
                DonutSmallItem(onClick = {}, donut = donut)
            }
        }
    }

}