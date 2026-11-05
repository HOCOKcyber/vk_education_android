package com.example.vk_education_android.domain

interface AppDetailsRepository {
    suspend fun getApps() : List<AppDetails>
    suspend fun getById(id: String): AppDetails
}