package com.example.domain.usecases

import com.example.domain.entities.CommunityDetails
import com.example.domain.repository.ICommunityRepository

class GetDetailsCommunityUseCase(
    val repository: ICommunityRepository,
) {
    fun execute(): CommunityDetails = repository.getDetailsCommunity()
}
