package com.example.vk_education_android.present

sealed class AppListEvent {
    data class ToDetails(val message: String): AppListEvent()
}