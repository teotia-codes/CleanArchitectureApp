package com.example.cleanarchitectureapp.store.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureapp.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvent(event:Any){
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}