package com.example.domain.usecases

import com.example.domain.entities.Community
import com.example.domain.entities.Meetings
import com.example.domain.repository.MeetingsRepository

class GetMeetingsUseCase(val repository: MeetingsRepository) {
    fun execute(): List<Meetings> {
        return repository.getMeetings()
    }
}