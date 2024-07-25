package com.example.wbtechnoschool

import com.example.data.repository.IMeetingsRepository
import com.example.domain.repository.MeetingsRepository
import com.example.domain.usecases.GetDescriptionMeetingsUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class GetDescriptionMeetingsUseCase {
    private val repoMeetings: MeetingsRepository = IMeetingsRepository()
    private val useCase: GetDescriptionMeetingsUseCase = GetDescriptionMeetingsUseCase(repoMeetings)
    @Test
    fun `getDescriptionMeetingsTest returns meetings details correct id`() {
        val expectedMeetingID = 1
        val actualMeetingDetails = useCase.execute()
        assertEquals(expectedMeetingID, actualMeetingDetails.id)
    }
}