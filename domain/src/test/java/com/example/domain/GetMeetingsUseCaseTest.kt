package com.example.domain

import com.example.domain.repository.IMeetingsRepositoryTest
import com.example.domain.repository.MeetingsRepository
import org.junit.Assert.assertFalse
import org.junit.Test

class GetMeetingsUseCaseTest {
    private val repoMeetings: MeetingsRepository = IMeetingsRepositoryTest()
    @Test
    fun `getMeetingsTest returns correct meetings`() {
        val allMeetings = repoMeetings.getMeetings()
        assertFalse(allMeetings.isEmpty())
    }
}