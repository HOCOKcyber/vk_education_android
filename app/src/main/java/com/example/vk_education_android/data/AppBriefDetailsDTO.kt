package com.example.vk_education_android.data

import com.example.vk_education_android.domain.Category
import kotlinx.serialization.Serializable

@Serializable
data class AppBriefDetailsDTO(
    val id: String,
    val name: String,
    val description: String,
    val category: Category,
    val iconUrl: String,
)