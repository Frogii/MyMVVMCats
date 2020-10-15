package com.example.mymvvmcats.api

import com.example.mymvvmcats.model.Cat
import retrofit2.Response
import retrofit2.http.GET

interface CatAPI {

    @GET("v1/images/search?mime_types=jpg&limit=20&order=Desc")
    suspend fun getCatsData(): Response<List<Cat>>
}