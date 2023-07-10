package com.mooncake.mydonuts.presntation.screens.home.composables

import androidx.compose.animation.Crossfade
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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mooncake.mydonuts.R
import com.mooncake.mydonuts.presntation.screens.home.Donut
import com.mooncake.mydonuts.presntation.ui.theme.Black
import com.mooncake.mydonuts.presntation.ui.theme.Black60
import com.mooncake.mydonuts.presntation.ui.theme.MyDonutsTheme
import com.mooncake.mydonuts.presntation.ui.theme.Pink
import com.mooncake.mydonuts.presntation.ui.theme.White

@Composable
fun DonutOfferItem(
    onClick: (Int) -> Unit,
    onClickFavourite: (Int) -> Unit,
    donut: Donut,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(targetValue = if (isPressed) 0.85f else 1f)

    Box(
        modifier = modifier
            .width(240.dp)
            .clickable(interactionSource, null) { onClick(donut.id) }
            .scale(scale)
    ) {
        Column(
            Modifier
                .size(190.dp, 325.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(donut.color)
                .padding(16.dp)
        ) {
            Crossfade(targetState = donut.isFavourite) {
                val favouriteIconRes = if (it) R.drawable.ic_heart_filled else R.drawable.ic_heart
                Icon(
                    painter = painterResource(id = favouriteIconRes),
                    contentDescription = "favourite",
                    tint = Pink,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(White)
                        .clickable { onClickFavourite(donut.id) }
                        .padding(4.dp),
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = donut.name,
                style = MaterialTheme.typography.labelMedium,
                color = Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = donut.description,
                style = MaterialTheme.typography.bodySmall,
                color = Black60,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                donut.offer?.let {
                    Text(
                        text = "$$it",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Black60
                        ),
                        textDecoration = TextDecoration.LineThrough,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                }
                Text(
                    text = "$${donut.finalPrice}",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 22.sp,
                        color = Black
                    ),
                )
            }
        }
        Image(
            painter = painterResource(id = donut.image),
            contentDescription = "donut image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 30.dp)
                .size(150.dp)
                .shadow(5.dp, shape = CircleShape)
                .align(Alignment.TopEnd)
        )
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview() {
    val donut = Donut(
        id = 1,
        image = R.drawable.donut_chocolate_glaze,
        name = "Chocolate Glaze",
        description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
        finalPrice = 16,
        offer = 20,
        isFavourite = true
    )
    MyDonutsTheme {
        LazyRow(
            Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(8) {
                DonutOfferItem(onClick = {}, onClickFavourite = {} ,donut = donut)
            }
        }
    }
}

