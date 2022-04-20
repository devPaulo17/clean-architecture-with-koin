package com.spacexapp.data

import com.google.android.gms.awareness.state.Weather
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.HttpException
import com.nhaarman.mockitokotlin2.mock
import retrofit2.Response
import java.net.SocketTimeoutException

@RunWith(JUnit4::class)
class ResponseHandlerTest {
    lateinit var responseHandler: ResponseHandler

    @Before
    fun setUp() {
        responseHandler = ResponseHandler()
    }

    @Test
    fun `when exception code is 401 then return unauthorised`() {
        val httpException = HttpException(Response.error<Weather>(401, mock()))
        val result = responseHandler.handleException<Weather>(httpException)
        assertEquals("Unauthorised", result.message)
    }

    @Test
    fun `when timeout then return timeout error`() {
        val socketTimeoutException = SocketTimeoutException()
        val result = responseHandler.handleException<Weather>(socketTimeoutException)
        assertEquals("Timeout", result.message)
    }
}