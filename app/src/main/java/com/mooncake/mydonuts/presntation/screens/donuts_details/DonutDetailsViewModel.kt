package com.mooncake.mydonuts.presntation.screens.donuts_details

import androidx.lifecycle.ViewModel
import com.mooncake.mydonuts.data.DataSource
import com.mooncake.mydonuts.presntation.navigation.DonutDetailsArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DonutDetailsViewModel @Inject constructor(
    private val dataSource: DataSource,
    private val donutDetailsArgs: DonutDetailsArgs
) : ViewModel(), DonutsDetailsInteractionsListener {
    private val _state = MutableStateFlow(DonutDetailsUiState())
    val state = _state.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        val donut = dataSource.getDonutById(donutDetailsArgs.donutId)
        _state.update {
            it.copy(
                id = donut.id,
                image = donut.image,
                isFavourite = donut.isFavourite,
                name = donut.name,
                about = donut.description,
                price = donut.finalPrice,
                color = donut.color
            )
        }
    }

    override fun onClickPlus() {
        _state.update { it.copy(quantity = it.quantity + 1) }
    }

    override fun onClickMinus() {
        if (state.value.quantity == 0) return
        _state.update { it.copy(quantity = it.quantity - 1) }
    }

    override fun onClickToggleFavourite() {
        dataSource.toggleFavourite(state.value.id)
        getData()
    }
}

interface DonutsDetailsInteractionsListener {
    fun onClickPlus()
    fun onClickMinus()
    fun onClickToggleFavourite()
}

