package com.example.vk_education_android.data

import com.example.vk_education_android.domain.AppDetails
import com.example.vk_education_android.domain.AppDetailsRepository

class AppDetailsRepositoryImpl(
    private val api: AppDetailsAPI,
) : AppDetailsRepository {
    val mapper = AppDetailsMapper()

    override suspend fun getApps(): List<AppDetails> {
        val result = api.getCatalogs()
        return result.map{ dto ->  mapper.fromBriefDTO(dto) }
    }

    override suspend fun getById(id: String): AppDetails {
        val result = api.getAppById(id)
        return mapper.fromFullDTO(result)
    }
}
