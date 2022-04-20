package com.spacexapp.data.remote.rockets

import com.spacexapp.data.ResponseHandler
import com.spacexapp.data.remote.retrofit.RocketsApiService
import com.spacexapp.domain.repository.RemoteRocketsDataSource

class RemoteRocketsDataSourceImpl(
    private val rocketsApiService: RocketsApiService,
    private val responseHandler: ResponseHandler
) :
    RemoteRocketsDataSource {
    override suspend fun getRockets(): String {
        return try {
            val response = rocketsApiService.getList()
            val aaa = response
            return "AHHHHHHHH"
        } catch (e: Exception) {
            "hola error"
        }
    }
}