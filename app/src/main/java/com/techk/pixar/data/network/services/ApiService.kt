package com.techk.pixar.data.network.services

import com.techk.pixar.BuildConfig
import com.techk.pixar.data.network.responses.UnsplashApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 10,
        @Query("client_id") id: String = BuildConfig.API_KEY
    ): UnsplashApiResponse

}