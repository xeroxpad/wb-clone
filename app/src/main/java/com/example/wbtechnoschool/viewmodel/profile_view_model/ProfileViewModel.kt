package com.example.wbtechnoschool.viewmodel.profile_view_model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel : ViewModel() {
    private val _isEditing = MutableStateFlow(false)
    val isEditing: StateFlow<Boolean> = _isEditing

    fun toggleEditing() {
        _isEditing.value = !_isEditing.value
    }

    fun setEditing(isEditing: Boolean) {
        _isEditing.value = isEditing
    }
}