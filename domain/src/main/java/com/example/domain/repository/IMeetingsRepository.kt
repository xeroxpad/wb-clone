package com.example.domain.repository

import com.example.domain.entities.FixEvent
import com.example.domain.entities.FixMeetingsDescription
import com.example.domain.entities.MeetingsDescription
import kotlinx.coroutines.flow.Flow

interface IMeetingsRepository {
    fun getMeetings(): FixEvent
    fun getDescriptionMeetings(): FixMeetingsDescription
}
