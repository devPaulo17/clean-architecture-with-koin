package com.spacexapp.domain.repository

import com.spacexapp.domain.HandleResult
import com.spacexapp.domain.Hello

interface HelloRepository {
    suspend fun giveHello(): HandleResult<List<Hello>>
}