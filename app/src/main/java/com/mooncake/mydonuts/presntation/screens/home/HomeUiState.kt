package com.mooncake.mydonuts.presntation.screens.home

import com.mooncake.mydonuts.presntation.screens.Donut

data class HomeUiState(
    val todayOffers: List<Donut> = emptyList(),
    val donuts: List<Donut> = emptyList(),
)