package com.example.domain.usecases

import com.example.domain.entities.Person
import com.example.domain.repository.ProfileRepository

class GetDataProfileUseCase(val repository: ProfileRepository) {
    fun execute(): Person {
        return repository.getDataProfileUseCase()
    }
}