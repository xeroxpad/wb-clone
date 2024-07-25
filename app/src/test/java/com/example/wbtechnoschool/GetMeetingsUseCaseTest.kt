package com.example.wbtechnoschool

import com.example.data.repository.IMeetingsRepository
import com.example.domain.repository.MeetingsRepository
import org.junit.Assert.assertFalse
import org.junit.Test

class GetMeetingsUseCaseTest {
    private val repoMeetings: MeetingsRepository = IMeetingsRepository()
    @Test
    fun `getMeetingsTest returns correct meetings`() {
        val allMeetings = repoMeetings.getMeetings()
        assertFalse(allMeetings.isEmpty())
    }
}