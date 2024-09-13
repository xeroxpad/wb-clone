package com.example.domain.usecases

import com.example.domain.entities.Community
import com.example.domain.repository.ICommunityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllCommunityUseCase(
    val repository: ICommunityRepository,
) {
    fun execute(): Flow<Community> = flow {
        val community = repository.getAllCommunity()
        emit(community)
    }
}
