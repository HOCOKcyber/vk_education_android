package com.example.vk_education_android.present.navigation

import kotlinx.serialization.Serializable

sealed class Route {

    @Serializable
    data class Details(val appId: String) : Route()

    @Serializable
    object AppList: Route()
}