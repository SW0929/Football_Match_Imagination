package com.example.front.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit2Builder {
    var api: ApiClientService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://175.199.225.21:8081")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiClientService::class.java)
    }
}