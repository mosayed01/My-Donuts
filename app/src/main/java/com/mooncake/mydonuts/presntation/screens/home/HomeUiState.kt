package com.mooncake.mydonuts.presntation.screens.home

data class HomeUiState(
    val todayOffers: List<Donut> = emptyList(),
    val donuts: List<Donut> = emptyList(),
)