package com.example.cleanarchitecturegitapp.networking

import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClientTest(
    private val mockWebServer: MockWebServer,
) : HttpClient.RetrofitClient {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(mockWebServer.url("/").toString())
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient
                    .Builder()
                    .connectTimeout(3, TimeUnit.SECONDS)
                    .readTimeout(3, TimeUnit.SECONDS)
                    .callTimeout(3, TimeUnit.SECONDS)
                    .writeTimeout(3, TimeUnit.SECONDS)
                    .build()
            )
            .build()
    }

    override fun <T> create(c: Class<T>): T = retrofit.create(c)
}
sealed interface HttpClient {
    interface RetrofitClient : HttpClient {
        fun <T> create(c: Class<T>): T
    }
}