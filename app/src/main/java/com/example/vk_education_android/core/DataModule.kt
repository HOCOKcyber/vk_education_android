package com.example.vk_education_android.core

import com.example.vk_education_android.data.AppDetailsAPI
import com.example.vk_education_android.data.AppDetailsRepositoryImpl
import com.example.vk_education_android.domain.AppDetailsRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideRetrofitAppDetailsAPI(): AppDetailsAPI{
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { HttpLoggingInterceptor.Level.BODY })
            .build()

        return Retrofit.Builder()
            .baseUrl("http://185.103.109.134/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()
            .create(AppDetailsAPI::class.java)
    }

    @Provides
    fun provideAppDetailsRepository(
        api: AppDetailsAPI
    ): AppDetailsRepository{
        return AppDetailsRepositoryImpl(api)
    }
}