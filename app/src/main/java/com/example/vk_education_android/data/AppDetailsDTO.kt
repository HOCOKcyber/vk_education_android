package com.example.vk_education_android.data

import com.example.vk_education_android.domain.Category
import kotlinx.serialization.Serializable

@Serializable
data class AppDetailsDTO(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>?,
    val description: String,
)
