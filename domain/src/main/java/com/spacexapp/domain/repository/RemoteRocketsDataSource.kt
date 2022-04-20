package com.spacexapp.domain.repository

import com.spacexapp.domain.HandleResult
import com.spacexapp.domain.Hello

interface RemoteRocketsDataSource {
    suspend fun getRockets(): HandleResult<List<Hello>>
}