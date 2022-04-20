package com.spacexapp.data.remote.rockets

import com.spacexapp.data.remote.entities.response.HelloApi
import com.spacexapp.domain.Hello


fun List<HelloApi>.toListRockets(): List<Hello> {
    return map { item ->
        Hello(
            id = item.id ?: "",
            name = item.name ?: " ",
            type = item.type ?: "",
            isActive = item.isActive ?: false
        )
    }
}
