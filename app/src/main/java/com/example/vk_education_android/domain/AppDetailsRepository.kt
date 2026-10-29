package com.example.vk_education_android.domain

interface AppDetailsRepository {
    fun get() : List<AppDetails>
}