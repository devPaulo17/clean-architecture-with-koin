package com.spacexapp.data.remote.entities.response

import kotlinx.serialization.Serializable

@Serializable
data class HelloApi(
    val id: String,
    val name: String,
    val type: String,
    val isActive: Boolean
)
