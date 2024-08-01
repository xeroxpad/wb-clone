package com.example.domain

import com.example.domain.repository.CommunityRepositoryTestStub
import com.example.domain.usecases.GetDetailsCommunityUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

internal class GetDetailsCommunityUseCaseTest {
    lateinit var repoCommunity: CommunityRepositoryTestStub
    lateinit var useCase: GetDetailsCommunityUseCase

    @Before
    fun setUp() {
        repoCommunity = CommunityRepositoryTestStub()
        useCase = GetDetailsCommunityUseCase(repoCommunity)
    }

    @Test
    fun `getDetailsCommunityTest returns community details correct id`() {
        val expectedCommunityID = 1
        val actualCommunityDetails = useCase.execute()
        assertNotNull("id не null", actualCommunityDetails.id)
        assertTrue("id типа Int", true)
        assertEquals(expectedCommunityID, actualCommunityDetails.id)
    }

    @Test
    fun `getDetailsCommunityTest returns community details object`() {
        val communityDetails = useCase.execute()
        assertNotNull(communityDetails)
    }

    @Test
    fun `getDetailsCommunityTest returns valid data`() {
        val communityDetails = useCase.execute()
        assertNotNull("title не null", communityDetails.title)
        assertTrue("title типа String", true)

        assertNotNull("detailsCommunity не null", communityDetails.detailsCommunity)
        assertTrue("detailsCommunity типа String", true)

        assertNotNull("meetingsCommunity не null", communityDetails.meetingsCommunity)
        assertTrue("meetingsCommunity типа List<Meetings>", true)

        for (meeting in communityDetails.meetingsCommunity) {
            assertNotNull("id не null", meeting.id)
            assertTrue("id типа Int", true)

            if (meeting.icon != null) {
                assertTrue("icon типа String", meeting.icon is String)
            } else {
                assertNull("icon null", meeting.icon)
            }
            assertNotNull("title не null", meeting.title)
            assertTrue("title типа String", true)

            assertNotNull("date не null", meeting.date)
            assertTrue("date типа String", true)

            assertNotNull("city не null", meeting.city)
            assertTrue("city типа String", true)

            assertNotNull("tagDevelopmentLanguage не null", meeting.tagDevelopmentLanguage)
            assertTrue("tagDevelopmentLanguage типа String", true)

            assertNotNull("tagGradeDeveloper не null", meeting.tagGradeDeveloper)
            assertTrue("tagGradeDeveloper типа String", true)

            assertNotNull("tagCityMeeting не null", meeting.tagCityMeeting)
            assertTrue("tagCityMeeting типа String", true)
        }
    }
}
