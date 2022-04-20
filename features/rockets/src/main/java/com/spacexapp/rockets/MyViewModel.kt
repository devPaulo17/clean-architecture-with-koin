package com.spacexapp.rockets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spacexapp.domain.HandleResult
import com.spacexapp.domain.repository.HelloRepository
import com.spacexapp.rockets.states.RocketsUiState
import kotlinx.coroutines.launch

class MyViewModel(val repository: HelloRepository) : ViewModel() {

    private val _viewState = MutableLiveData<RocketsUiState>(RocketsUiState.Loading)
    val viewState: LiveData<RocketsUiState> = _viewState

    fun sayHello() {
        viewModelScope.launch {
            _viewState.value = when (val result = repository.giveHello()) {
                HandleResult.Loading -> RocketsUiState.Loading
                is HandleResult.Success -> {
                    RocketsUiState.ListCategories(result.data)
                }
                is HandleResult.InternetConnectionError -> RocketsUiState.ErrorConnection
                is HandleResult.Error -> RocketsUiState.Error
            }
        }
    }
}