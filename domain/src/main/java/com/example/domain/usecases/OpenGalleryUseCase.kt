package com.example.domain.usecases

import com.example.domain.repository.IGalleryRepository

class OpenGalleryUseCase(private val galleryRepository: IGalleryRepository) {
    fun execute() {
        galleryRepository.openGallery()
    }
}

