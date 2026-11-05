package com.example.vk_education_android.data

import com.example.vk_education_android.domain.AppDetails
import com.example.vk_education_android.domain.AppDetailsRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class AppDetailsRepositoryImpl: AppDetailsRepository {

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { HttpLoggingInterceptor.Level.BODY })
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://185.103.109.134/")
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .client(okHttpClient)
        .build()
        .create(AppDetailsAPI::class.java)

    val mapper = AppDetailsMapper()

    override suspend fun getApps(): List<AppDetails> {
        val result = retrofit.getCatalogs()
        return result.map{ dto ->  mapper.fromBriefDTO(dto) }
    }

    override suspend fun getById(id: String): AppDetails {
        val result = retrofit.getAppById(id)
        return mapper.fromFullDTO(result)
    }
}
