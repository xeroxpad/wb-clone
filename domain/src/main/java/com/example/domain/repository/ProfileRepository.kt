package com.example.domain.repository

import com.example.domain.entities.Community
import com.example.domain.entities.Person

interface ProfileRepository {
    fun getDataProfileUseCase(): Person
}