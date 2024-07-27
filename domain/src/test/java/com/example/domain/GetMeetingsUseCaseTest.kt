package com.example.domain

import com.example.domain.repository.MeetingsRepositoryTestStub
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class GetMeetingsUseCaseTest {
    private val repoMeetings = MeetingsRepositoryTestStub()

    @Test
    fun `getMeetingsTest returns correct meetings`() {
        val allMeetings = repoMeetings.getMeetings()
        assertFalse("список не пустой", allMeetings.isEmpty())
    }

    @Test
    fun `getMeetingsTest returns valid data`() {
        val allMeetings = repoMeetings.mockMeetings
        for (meeting in allMeetings) {
            assertNotNull("id не null", meeting.id)
            assertTrue("id типа Int", meeting.id is Int)

            if (meeting.icon != null) {
                assertTrue("icon типа String", meeting.icon is String)
            } else {
                assertNull("icon null", meeting.icon)
            }
            assertNotNull("title не null", meeting.title)
            assertTrue("title типа String", meeting.title is String)

            assertNotNull("date не null", meeting.date)
            assertTrue("date типа String", meeting.date is String)

            assertNotNull("city не null", meeting.city)
            assertTrue("city типа String", meeting.city is String)

            assertNotNull("tagDevelopmentLanguage не null", meeting.tagDevelopmentLanguage)
            assertTrue("tagDevelopmentLanguage типа String", meeting.tagDevelopmentLanguage is String)

            assertNotNull("tagGradeDeveloper не null", meeting.tagGradeDeveloper)
            assertTrue("tagGradeDeveloper типа String", meeting.tagGradeDeveloper is String)

            assertNotNull("tagCityMeeting не null", meeting.tagCityMeeting)
            assertTrue("tagCityMeeting типа String", meeting.tagCityMeeting is String)
        }
    }
}