package com.spacexapp.rockets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spacexapp.domain.repository.HelloRepository
import kotlinx.coroutines.launch

class MyViewModel(val repo: HelloRepository) : ViewModel() {

    fun sayHello(): String {
        var hola = "nada"
        viewModelScope.launch {
            hola = "${repo.giveHello()} from $this"
        }

        return hola
    }
}