package com.techk.pixar.domain.repositories

import com.techk.pixar.data.models.UnsplashApiResponse

interface UnsplashRepo {

    suspend fun getUnsplashResponse(): UnsplashApiResponse

}