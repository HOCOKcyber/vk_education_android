package com.example.vk_education_android.present


import androidx.compose.runtime.Immutable
import com.example.vk_education_android.domain.AppDetails
import com.example.vk_education_android.domain.SimilarApp

@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val similarApps: List<SimilarApp>,
        val descriptionCollapsed: Boolean,
        val appShowcase: List<AppDetails>
    ) : AppDetailsState
}