package com.example.data.repository

import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import com.example.domain.repository.IGalleryRepository

class GalleryRepositoryImpl(private val context: Context) : IGalleryRepository {
        override fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }
}