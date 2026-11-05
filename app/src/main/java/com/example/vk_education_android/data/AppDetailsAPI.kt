package com.example.vk_education_android.data

import retrofit2.http.GET
import retrofit2.http.Path

interface AppDetailsAPI {
    @GET("catalog")
    suspend fun getCatalogs(): List<AppBriefDetailsDTO>

    @GET("catalog/{id}")
    suspend fun getAppById(@Path("id") id: String): AppDetailsDTO
}