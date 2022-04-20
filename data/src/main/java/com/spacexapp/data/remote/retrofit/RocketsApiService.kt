package com.spacexapp.data.remote.retrofit

import com.spacexapp.data.remote.entities.response.HelloApi
import retrofit2.Response
import retrofit2.http.GET

interface RocketsApiService {

    @GET("v3/dragons")
    suspend fun getList(): Response<List<HelloApi>>
}