package com.mooncake.mydonuts.presntation.screens.donuts_details

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.mooncake.mydonuts.R
import com.mooncake.mydonuts.presntation.ui.theme.BlueLight
import com.mooncake.mydonuts.presntation.ui.theme.PinkLight

data class DonutDetailsUiState(
    val id: Int = 0,
    @DrawableRes val image: Int = R.drawable.donut_chocolate_glaze,
    val isFavourite: Boolean = false,
    val name: String = "",
    val about: String = "",
    val quantity: Int = 0,
    val price: Int = 20,
    val color: Color = listOf(BlueLight, PinkLight).random()
) {
    val totalPrice
        get() = price * quantity
}

/*
DonutDetails{
image: DrawRes
isFavourait
name
about
quantity
price
totalPrice
}

 */
