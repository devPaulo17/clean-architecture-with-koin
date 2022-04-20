package com.spacexapp.domain.di

import com.spacexapp.domain.repository.HelloRepository
import com.spacexapp.domain.repository.HelloRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryDi = module{

    factory<HelloRepository> {
        HelloRepositoryImpl(get())
    }
}