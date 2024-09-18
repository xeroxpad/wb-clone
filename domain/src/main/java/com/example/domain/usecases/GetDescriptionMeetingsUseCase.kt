package com.example.domain.usecases

import com.example.domain.entities.FixMeetingsDescription
import com.example.domain.entities.MeetingsDescription
import com.example.domain.repository.IMeetingsRepository

class GetDescriptionMeetingsUseCase(
    val repository: IMeetingsRepository,
) {
    fun execute(): FixMeetingsDescription = repository.getDescriptionMeetings()
}
