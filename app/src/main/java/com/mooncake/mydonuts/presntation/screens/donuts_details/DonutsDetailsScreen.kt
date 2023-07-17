package com.mooncake.mydonuts.presntation.screens.donuts_details

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mooncake.mydonuts.R
import com.mooncake.mydonuts.presntation.composables.ButtonHasText
import com.mooncake.mydonuts.presntation.ui.theme.Black
import com.mooncake.mydonuts.presntation.ui.theme.Black60
import com.mooncake.mydonuts.presntation.ui.theme.LocalNavController
import com.mooncake.mydonuts.presntation.ui.theme.MyDonutsTheme
import com.mooncake.mydonuts.presntation.ui.theme.Pink
import com.mooncake.mydonuts.presntation.ui.theme.White
import com.mooncake.mydonuts.presntation.ui.theme.WhiteFE

@Composable
fun DonutsDetailsScreen(viewModel: DonutDetailsViewModel = hiltViewModel()) {
    val navController = LocalNavController.current
    val state by viewModel.state.collectAsState()
    DonutsDetailsScreenContent(
        navigateBack = { navController.popBackStack() },
        state = state,
        listener = viewModel
    )
}

@Composable
fun DonutsDetailsScreenContent(
    navigateBack: () -> Unit,
    state: DonutDetailsUiState,
    listener: DonutsDetailsInteractionsListener,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize().background(state.color)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "back",
            tint = Pink,
            modifier = Modifier
                .padding(start = 16.dp, top = 24.dp)
                .clip(CircleShape)
                .clickable { navigateBack() }
        )
        Image(
            painter = painterResource(id = state.image), contentDescription = "image",
            modifier = Modifier
                .size(300.dp)
                .padding(horizontal = 40.dp)
                .align(CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        BottomSheetContent(state, listener, modifier = Modifier.weight(1f))
    }
}

@Composable
fun BottomSheetContent(
    state: DonutDetailsUiState,
    listener: DonutsDetailsInteractionsListener,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            Modifier
                .matchParentSize()
                .padding(top = 20.dp)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(WhiteFE)
                .padding(horizontal = 40.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = state.name,
                style = MaterialTheme.typography.headlineLarge.copy(color = Pink),
                modifier = Modifier.padding(top = 35.dp)
            )
            Text(
                text = "About Gonut",
                style = MaterialTheme.typography.titleMedium.copy(color = Black),
                modifier = Modifier.padding(top = 33.dp)
            )
            Text(
                text = state.about,
                style = MaterialTheme.typography.bodyMedium.copy(color = Black60),
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Quantity", style = MaterialTheme.typography.titleMedium.copy(color = Black),
                modifier = Modifier.padding(top = 26.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(top = 19.dp)
            ) {
                Text(
                    text = "-",
                    style = MaterialTheme.typography.headlineLarge.copy(fontSize = 32.sp),
                    modifier = Modifier
                        .size(45.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(White)
                        .clickable { listener.onClickMinus() },
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "${state.quantity}",
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 22.sp),
                    modifier = Modifier
                        .size(45.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(White)
                        .padding(top = 8.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "+",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 32.sp,
                        color = White
                    ),
                    modifier = Modifier
                        .size(45.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Black)
                        .clickable { listener.onClickPlus() },
                    textAlign = TextAlign.Center
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 16.dp)
            ) {
                Text(text = "£${state.totalPrice}", style = MaterialTheme.typography.headlineLarge)
                ButtonHasText(
                    text = "Add to Cart",
                    onClick = { /*TODO*/ },
                    containerColor = Pink,
                    textColor = White,
                    modifier = Modifier.width(240.dp)
                )
            }
        }

        Crossfade(
            targetState = state.isFavourite,
            modifier = Modifier
                .padding(bottom = 42.dp, end = 32.dp)
                .align(Alignment.TopEnd)
        ) {
            val favouriteIconRes = if (it) R.drawable.ic_heart_filled else R.drawable.ic_heart
            Icon(
                painter = painterResource(id = favouriteIconRes),
                contentDescription = "favourite",
                tint = Pink,
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(White)
                    .clickable { listener.onClickToggleFavourite() }
                    .padding(6.dp),
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview() {
    MyDonutsTheme {
        DonutsDetailsScreenContent(
            navigateBack = {},
            DonutDetailsUiState(
                name = "Strawberry Wheel",
                about = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
            ),
            object : DonutsDetailsInteractionsListener {
                override fun onClickPlus() {
                    TODO("Not yet implemented")
                }

                override fun onClickMinus() {
                    TODO("Not yet implemented")
                }

                override fun onClickToggleFavourite() {
                    TODO("Not yet implemented")
                }
            })
    }
}