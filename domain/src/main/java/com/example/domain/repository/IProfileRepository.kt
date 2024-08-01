package com.example.domain.repository

import com.example.domain.entities.Person

interface IProfileRepository {
    fun getDataProfileUseCase(): Person
}
