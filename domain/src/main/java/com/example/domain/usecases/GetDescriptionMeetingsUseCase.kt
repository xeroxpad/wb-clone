package com.example.domain.usecases

import com.example.domain.entities.MeetingsDescription
import com.example.domain.repository.IMeetingsRepository

class GetDescriptionMeetingsUseCase(
    val repository: IMeetingsRepository,
) {
    fun execute(): MeetingsDescription = repository.getDescriptionMeetings()
}
