package com.example.front.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    var api: ApiClientService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("YOUR_URL")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiClientService::class.java)
    }
}