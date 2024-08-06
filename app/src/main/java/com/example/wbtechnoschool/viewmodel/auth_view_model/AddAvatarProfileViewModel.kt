package com.example.wbtechnoschool.viewmodel.auth_view_model

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.OpenGalleryUseCase

class AddAvatarProfileViewModel(private val openGalleryUseCase: OpenGalleryUseCase) : ViewModel() {
    fun openGallery() {
        openGalleryUseCase.execute()
    }
}