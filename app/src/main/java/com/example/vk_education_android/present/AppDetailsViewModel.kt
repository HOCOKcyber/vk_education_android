package com.example.vk_education_android.present

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.vk_education_android.data.AppDetailsRepositoryImpl
import com.example.vk_education_android.domain.AppDetailsRepository
import com.example.vk_education_android.present.navigation.Route
import com.example.vk_education_android.utils.MockData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppDetailsViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val repository: AppDetailsRepository = AppDetailsRepositoryImpl()

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val appId = savedStateHandle.toRoute<Route.Details>().appId
            val appDetails = repository.getById(appId)
            _state.value = AppDetailsState.Content(
                appDetails = appDetails,
                descriptionCollapsed = false,
                similarApps = MockData.getMockSimilarApps(),
                appShowcase = MockData.getMockShowcase()
            )
        }
    }
}

