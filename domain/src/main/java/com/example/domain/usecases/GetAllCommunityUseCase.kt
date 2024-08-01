package com.example.domain.usecases

import com.example.domain.entities.Community
import com.example.domain.repository.ICommunityRepository

class GetAllCommunityUseCase(
    val repository: ICommunityRepository,
) {
    fun execute(): List<Community> = repository.getAllCommunity()
}
