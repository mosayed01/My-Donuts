package com.mooncake.mydonuts.presntation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mooncake.mydonuts.R
import com.mooncake.mydonuts.data.DataSource
import com.mooncake.mydonuts.presntation.navigation.navigateToDonutDetails
import com.mooncake.mydonuts.presntation.screens.home.composables.DonutOfferItem
import com.mooncake.mydonuts.presntation.screens.home.composables.DonutSmallItem
import com.mooncake.mydonuts.presntation.ui.theme.Black
import com.mooncake.mydonuts.presntation.ui.theme.Black60
import com.mooncake.mydonuts.presntation.ui.theme.LocalNavController
import com.mooncake.mydonuts.presntation.ui.theme.LocalSystemUiController
import com.mooncake.mydonuts.presntation.ui.theme.MyDonutsTheme
import com.mooncake.mydonuts.presntation.ui.theme.Pink
import com.mooncake.mydonuts.presntation.ui.theme.PinkLight
import com.mooncake.mydonuts.presntation.ui.theme.WhiteFC

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    LocalSystemUiController.current.isSystemBarsVisible = true
    val navController = LocalNavController.current
    val state by viewModel.state.collectAsState()
    HomeScreenContent(navigateToDonutsDetails = {
        navController.navigateToDonutDetails(it)
    }, state = state, lister = viewModel)
}

@Composable
fun HomeScreenContent(
    navigateToDonutsDetails: (Int) -> Unit,
    state: HomeUiState,
    lister: HomeInteractionsLister,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
    ) {
        item {
            Header(
                Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp))
        }
        item {
            Text(
                text = "Today Offers",
                style = MaterialTheme.typography.titleLarge.copy(color = Black),
                modifier = Modifier.padding(start = 16.dp, top = 32.dp)
            )
            LazyRow(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(state.todayOffers) { donut ->
                    DonutOfferItem(
                        onClick = { navigateToDonutsDetails(it) },
                        onClickFavourite = lister::onClickFavourite,
                        donut = donut
                    )
                }
            }
        }
        item {
            Text(
                text = "Donuts",
                style = MaterialTheme.typography.titleLarge.copy(color = Black),
                modifier = Modifier.padding(start = 16.dp, top = 32.dp)
            )
            LazyRow(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(state.donuts) { donut ->
                    DonutSmallItem(onClick = { navigateToDonutsDetails(it) }, donut = donut)
                }
            }
        }
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Let’s Gonuts!",
                style = MaterialTheme.typography.headlineLarge.copy(color = Pink)
            )
            Text(
                text = "Order your favourite donuts from here",
                style = MaterialTheme.typography.bodyLarge.copy(color = Black60)
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Pink,
            modifier = Modifier
                .background(PinkLight, shape = RoundedCornerShape(15.dp))
                .padding(8.dp)
                .size(24.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview() {
    MyDonutsTheme {
        HomeScreenContent(
            state = HomeUiState(DataSource().getDonutsWithOffers(), DataSource().getAllDonuts()),
            navigateToDonutsDetails = {},
            lister = object : HomeInteractionsLister {
                override fun onClickFavourite(donutId: Int) {
                    TODO("Not yet implemented")
                }
            },
        )
    }
}