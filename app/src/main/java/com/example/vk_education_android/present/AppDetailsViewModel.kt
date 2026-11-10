package com.example.vk_education_android.present

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.vk_education_android.domain.AppDetailsRepository
import com.example.vk_education_android.present.navigation.Route
import com.example.vk_education_android.utils.MockData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: AppDetailsRepository
): ViewModel() {

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
                appShowcase = MockData.getMockShowcase(),
                installState = InstallState.NotInstall
            )
        }
    }

    private var installJob: Job? = null

    fun onInstallClick(){
        if (_state.value !is AppDetailsState.Content) return

        val current = _state.value as AppDetailsState.Content


        when(current.installState){
            is InstallState.NotInstall -> {
                installJob = viewModelScope.launch {
                    for (p in 0..100 step 5){
                        delay(150.milliseconds)
                        _state.value = (_state.value as AppDetailsState.Content).copy(
                            installState = InstallState.Installing(p)
                        )
                    }
                    _state.value = (_state.value as AppDetailsState.Content).copy(
                        installState = InstallState.Installed
                    )
                }
            }
            is InstallState.Installing -> {
                installJob?.cancel()
                _state.value = current.copy(
                    installState = InstallState.NotInstall
                )
            }
            is InstallState.Installed -> {}
        }
    }
}

