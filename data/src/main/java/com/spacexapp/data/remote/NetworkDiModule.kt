package com.spacexapp.data.remote

import com.spacexapp.data.BuildConfig
import com.spacexapp.data.ResponseHandler
import com.spacexapp.data.remote.retrofit.RocketsApiService
import com.spacexapp.data.remote.rockets.RemoteRocketsDataSourceImpl
import com.spacexapp.domain.repository.RemoteRocketsDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {

    factory { provideOkHttpClient(get()) }
    factory { provideForecastApi(get()) }
    factory { provideLoggingInterceptor() }
    single { provideRetrofit(get()) }
    factory { ResponseHandler() }

    factory<RemoteRocketsDataSource> {
        RemoteRocketsDataSourceImpl(get(),get())
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("https://api.spacexdata.com/").client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()
}

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BODY
    return logger
}

fun provideForecastApi(retrofit: Retrofit): RocketsApiService =
    retrofit.create(RocketsApiService::class.java)


