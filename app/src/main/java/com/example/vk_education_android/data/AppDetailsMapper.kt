package com.example.vk_education_android.data

import com.example.vk_education_android.domain.AppDetails

class AppDetailsMapper {

    fun fromBriefDTO(details: AppBriefDetailsDTO) =
        AppDetails(
            id = details.id,
            iconUrl = details.iconUrl,
            description = details.description,
            name = details.name,
            category = details.category,

            developer = "null",
            size = .0f,
            screenshotUrlList = listOf(),
            ageRating = 0,
        )

    fun fromFullDTO(details: AppDetailsDTO) =
        AppDetails(
            id = details.id,
            iconUrl = details.iconUrl,
            description = details.description,
            name = details.name,
            category = details.category,

            developer = details.developer,
            size = details.size,
            screenshotUrlList = details.screenshotUrlList,
            ageRating = details.ageRating,
        )

}