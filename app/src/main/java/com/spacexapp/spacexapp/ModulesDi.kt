package com.spacexapp.spacexapp

import com.spacexapp.data.remote.networkModule
import com.spacexapp.domain.di.repositoryDi
import com.spacexapp.rockets.rocketsModule

val MODULES_DI = listOf(
    repositoryDi,
    rocketsModule,
    networkModule
)