package com.mooncake.mydonuts.data

import com.mooncake.mydonuts.R
import com.mooncake.mydonuts.presntation.screens.home.Donut
import com.mooncake.mydonuts.presntation.ui.theme.BlueLight
import com.mooncake.mydonuts.presntation.ui.theme.PinkLight
import com.mooncake.mydonuts.presntation.ui.theme.PinkMedium
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSource @Inject constructor() {
    fun getDonutsWithOffers(): List<Donut> {
        return donutsList.filter { it.offer != null }.toList()
    }

    fun getAllDonuts(): List<Donut> {
        return donutsList.toList()
    }

    fun getDonutById(id: Int): Donut {
        return donutsList.find { it.id == id } ?: donutsList.last()
    }

    fun toggleFavourite(donutId: Int) {
        val oldDonut = getDonutById(donutId)
        donutsList[donutId] = oldDonut.copy(isFavourite = !oldDonut.isFavourite)
    }

    companion object {
        private val donutsList = mutableListOf(
            Donut(
                id = 0,
                R.drawable.donut_chocolate_glaze,
                name = "Chocolate Glaze",
                description = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                finalPrice = 16,
                offer = 20,
                isFavourite = false,
                color = PinkMedium
            ),
            Donut(
                id = 1,
                R.drawable.donut_strawberry_wheel,
                name = "Strawberry Wheel",
                description = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                finalPrice = 14,
                offer = 20,
                isFavourite = false,
                color = BlueLight
            ),
            Donut(
                id = 2,
                R.drawable.donut_strawberry_rain,
                name = "Strawberry Cool",
                description = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                finalPrice = 10,
                offer = 20,
                isFavourite = false,
                color = PinkLight
            ),
            Donut(
                id = 3,
                R.drawable.small_chocolate_cherry,
                name = "Chocolate Cherry",
                description = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                finalPrice = 22,
            ),
            Donut(
                id = 4,
                R.drawable.small_strawberry_rain,
                name = "Strawberry Rain",
                description = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                finalPrice = 22,
            ),
            Donut(
                id = 5,
                R.drawable.small_strawberry,
                name = "Strawberry",
                description = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                finalPrice = 22,
            ),
        )
    }
}