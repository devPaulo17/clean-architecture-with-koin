package com.spacexapp.domain.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HelloRepositoryImpl(private val remote: RemoteRocketsDataSource) : HelloRepository {
    override suspend fun giveHello(): String {
        return withContext(Dispatchers.IO) {
            remote.getRockets()
        }
    }
}