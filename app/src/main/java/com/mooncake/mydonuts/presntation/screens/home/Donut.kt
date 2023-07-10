package com.mooncake.mydonuts.presntation.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.mooncake.mydonuts.presntation.ui.theme.BlueLight
import com.mooncake.mydonuts.presntation.ui.theme.PinkLight
import com.mooncake.mydonuts.presntation.ui.theme.PinkMedium

data class Donut(
    val id: Int,
    @DrawableRes val image: Int,
    val name: String = "",
    val description: String = "",
    val finalPrice: Int = 22,
    val offer: Int? = null,
    val isFavourite: Boolean = false,
    val color: Color = listOf(BlueLight, PinkMedium, PinkLight).random()
)