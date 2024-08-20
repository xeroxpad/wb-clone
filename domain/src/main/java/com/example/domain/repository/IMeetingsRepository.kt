package com.example.domain.repository

import com.example.domain.entities.FixEvent
import com.example.domain.entities.Meetings
import com.example.domain.entities.MeetingsDescription

interface IMeetingsRepository {
    fun getMeetings(): List<FixEvent>
    fun getDescriptionMeetings(): MeetingsDescription
}
