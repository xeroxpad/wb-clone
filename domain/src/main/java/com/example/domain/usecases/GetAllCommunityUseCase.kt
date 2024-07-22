package com.example.domain.usecases

import com.example.domain.entities.Community
import com.example.domain.repository.CommunityRepository

class GetAllCommunityUseCase(val repository: CommunityRepository) {
    fun execute(): List<Community> {
        return repository.getAllCommunity()
    }
}