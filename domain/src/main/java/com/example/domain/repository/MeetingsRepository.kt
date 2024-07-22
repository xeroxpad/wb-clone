package com.example.domain.repository

import com.example.domain.entities.Meetings
import com.example.domain.entities.MeetingsDescription

interface MeetingsRepository {
    fun getMeetings(): List<Meetings>
    fun getDescriptionMeetings(): MeetingsDescription
}