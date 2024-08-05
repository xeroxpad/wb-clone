package com.example.wbtechnoschool.viewmodel.auth_view_model

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.domain.usecases.OpenGalleryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddAvatarProfileViewModel(private val openGalleryUseCase: OpenGalleryUseCase): ViewModel() {
    fun openGallery() {
        openGalleryUseCase.execute()
    }
}