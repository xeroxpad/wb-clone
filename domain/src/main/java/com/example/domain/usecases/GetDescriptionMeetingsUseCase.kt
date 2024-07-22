package com.example.domain.usecases

import com.example.domain.entities.MeetingsDescription
import com.example.domain.repository.MeetingsRepository

class GetDescriptionMeetingsUseCase(val repository: MeetingsRepository) {
    fun execute(): MeetingsDescription {
        return repository.getDescriptionMeetings()
    }
}