package com.spacexapp.data.remote.rockets

import com.spacexapp.data.remote.retrofit.RocketsApiService
import com.spacexapp.data.remote.retrofit.executeRetrofitRequest
import com.spacexapp.data.remote.retrofit.handleResultRetrofit
import com.spacexapp.domain.HandleResult
import com.spacexapp.domain.Hello
import com.spacexapp.domain.repository.RemoteRocketsDataSource


class RemoteRocketsDataSourceImpl(
    private val rocketsApiService: RocketsApiService,
) :
    RemoteRocketsDataSource {
    override suspend fun getRockets(): HandleResult<List<Hello>> {
        val result = executeRetrofitRequest {
            rocketsApiService.getList()
        }

        return handleResultRetrofit(result) { rockets ->
            rockets?.toListRockets()?: emptyList()
        }
    }
}