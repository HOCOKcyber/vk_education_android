package com.example.vk_education_android.present

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vk_education_android.domain.AppDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val repository: AppDetailsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(
        AppListState(
            apps = listOf()
    ))

    init {
        viewModelScope.launch {
            val appsList = repository.getApps()
            _state.value = _state.value.copy(
                apps = appsList
            )
            }
    }

    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>()
    val events = _events.receiveAsFlow()

    fun showSnackBar(message: String){
        viewModelScope.launch {
            _events.send(AppListEvent.ToDetails(message))
        }
    }
}

