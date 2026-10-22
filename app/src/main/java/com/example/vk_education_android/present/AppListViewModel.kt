package com.example.vk_education_android.present

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AppListViewModel: ViewModel() {
    private val _state = MutableStateFlow(
        AppListState(
            apps = getAppCards()
    ))

    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>()
    val events = _events.receiveAsFlow()

    fun showSnackBar(message: String){
        viewModelScope.launch {
            _events.send(AppListEvent.ToDetails(message))
        }
    }
}

