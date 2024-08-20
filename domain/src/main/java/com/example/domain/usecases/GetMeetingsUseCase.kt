package com.example.domain.usecases

import com.example.domain.entities.FixEvent
import com.example.domain.entities.Meetings
import com.example.domain.repository.IMeetingsRepository

class GetMeetingsUseCase(
    val repository: IMeetingsRepository,
) {
    fun execute(): List<FixEvent> = repository.getMeetings()
}
