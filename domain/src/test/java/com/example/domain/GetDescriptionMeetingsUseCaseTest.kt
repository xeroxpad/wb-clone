package com.example.domain

import com.example.domain.repository.MeetingsRepositoryTestStub
import com.example.domain.usecases.GetDescriptionMeetingsUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

internal class GetDescriptionMeetingsUseCaseTest {
    private lateinit var repoMeetings: MeetingsRepositoryTestStub
    private lateinit var useCase: GetDescriptionMeetingsUseCase

    @Before
    fun setUp() {
        repoMeetings = MeetingsRepositoryTestStub()
        useCase = GetDescriptionMeetingsUseCase(repoMeetings)
    }

    @Test
    fun `getDescriptionMeetingsTest returns meetings details correct id`() {
        val expectedMeetingID = 1
        val actualMeetingDetails = useCase.execute()
        assertNotNull("id не null", actualMeetingDetails.id)
        assertTrue("id типа Int", actualMeetingDetails.id is Int)
        assertEquals(expectedMeetingID, actualMeetingDetails.id)
    }

    @Test
    fun `getDescriptionMeetingsTest returns meetings details object`() {
        val meetingDescription = useCase.execute()
        assertNotNull(meetingDescription)
    }

    @Test
    fun `getDescriptionMeetingsTest returns valid data`() {
        val meetingDescription = repoMeetings.mockMeetingsDescriptionData
        assertNotNull("id не null", meetingDescription.id)
        assertTrue("id типа Int", meetingDescription.id is Int)
        assertNotNull("title не null", meetingDescription.title)
        assertTrue("title типа String", meetingDescription.title is String)
        assertNotNull("dateAndLocation не null", meetingDescription.dateAndLocation)
        assertTrue("dateAndLocation типа String", meetingDescription.dateAndLocation is String)
        assertNotNull("tags не null", meetingDescription.tags)
        assertTrue("tags типа List<String>", meetingDescription.tags is List<String>)
        assertNotNull("map не null", meetingDescription.map)
        assertTrue("map типа String", meetingDescription.map is String)
        assertNotNull("description не null", meetingDescription.description)
        assertTrue("description типа String", meetingDescription.description is String)
        assertNotNull("rowAvatars не null", meetingDescription.rowAvatars)
        assertTrue("rowAvatars типа String", meetingDescription.rowAvatars is List<String>)
    }
}
