package com.techk.pixar.data.network.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class UnsplashApiResponse(
    @SerializedName("results") val list: List<UnsplashApiResponseItem>
)

@Parcelize
data class UnsplashApiResponseItem(
    @SerializedName("id") val id: String?,
    @SerializedName("likes") val likes: Int?,
    @SerializedName("urls") val urls: Urls?,
    @SerializedName("user") val user: User?,
) : Parcelable

@Parcelize
data class Urls(
    @SerializedName("full") val full: String?,
    @SerializedName("raw") val raw: String?,
    @SerializedName("regular") val regular: String?,
    @SerializedName("small") val small: String?,
) : Parcelable

@Parcelize
data class User(
    @SerializedName("username") val username: String?
) : Parcelable {
    val attributionUrl get() = "https://unsplash.com/$username?utm_source=Pixar&utm_medium=referral"
}