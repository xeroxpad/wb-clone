package com.example.domain.usecases

import com.example.domain.entities.FixEvent
import com.example.domain.repository.IMeetingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMeetingsUseCase(
    val repository: IMeetingsRepository,
) {
    fun execute(): Flow<FixEvent> = flow {
        val meetings = repository.getMeetings()
        emit(meetings)
    }
}
