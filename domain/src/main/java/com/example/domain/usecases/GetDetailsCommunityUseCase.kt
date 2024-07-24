package com.example.domain.usecases

import com.example.domain.entities.Community
import com.example.domain.entities.CommunityDetails
import com.example.domain.repository.CommunityRepository

class GetDetailsCommunityUseCase(val repository: CommunityRepository) {
    fun execute(): CommunityDetails {
        return repository.getDetailsCommunity()
    }
}