package com.spacexapp.domain.repository

interface HelloRepository {
    suspend fun giveHello(): String
}