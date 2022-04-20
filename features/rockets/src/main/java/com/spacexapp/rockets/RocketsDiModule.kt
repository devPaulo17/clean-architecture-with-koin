package com.spacexapp.rockets

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val rocketsModule = module {
    viewModel { MyViewModel(get()) }
}
