package com.spacexapp.rockets.states

import com.spacexapp.domain.Hello

sealed class RocketsUiState{
    object Loading : RocketsUiState()
    data class ListCategories(val data: List<Hello>) : RocketsUiState()
    object Error : RocketsUiState()
    object ErrorConnection : RocketsUiState()
}

