package com.mooncake.mydonuts.presntation.screens.home

import androidx.lifecycle.ViewModel
import com.mooncake.mydonuts.data.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataSource: DataSource
) : ViewModel(),HomeInteractionsLister {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        val allDonuts = dataSource.getAllDonuts()
        val todayOffer = dataSource.getDonutsWithOffers()
        _state.update { it.copy(todayOffers = todayOffer, donuts = allDonuts) }
    }

    override fun onClickFavourite(donutId: Int) {
        dataSource.toggleFavourite(donutId)
        getData()
    }
}

interface HomeInteractionsLister {
    fun onClickFavourite(donutId: Int)
}