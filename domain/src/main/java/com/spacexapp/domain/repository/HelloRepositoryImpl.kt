package com.spacexapp.domain.repository

import com.spacexapp.domain.HandleResult
import com.spacexapp.domain.Hello
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HelloRepositoryImpl(private val remote: RemoteRocketsDataSource) : HelloRepository {
    override suspend fun giveHello(): HandleResult<List<Hello>> {
        return withContext(Dispatchers.IO) {
            remote.getRockets()
        }
    }
}