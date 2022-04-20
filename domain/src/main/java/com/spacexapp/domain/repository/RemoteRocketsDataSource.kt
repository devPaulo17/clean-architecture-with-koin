package com.spacexapp.domain.repository

interface RemoteRocketsDataSource {
    suspend fun getRockets():String
}