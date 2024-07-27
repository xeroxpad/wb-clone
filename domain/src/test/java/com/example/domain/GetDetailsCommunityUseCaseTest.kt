package com.example.domain

import com.example.domain.repository.CommunityRepository
import com.example.domain.repository.ICommunityRepositoryTest
import com.example.domain.usecases.GetDetailsCommunityUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class GetDetailsCommunityUseCaseTest {
    private val repoCommunity: CommunityRepository = ICommunityRepositoryTest()
    private val useCase: GetDetailsCommunityUseCase = GetDetailsCommunityUseCase(repoCommunity)
    @Test
    fun `getDetailsCommunityTest returns community details correct id`() {
        val expectedCommunityID = 1
        val actualCommunityDetails = useCase.execute()
        assertEquals(expectedCommunityID, actualCommunityDetails.id)
    }

    @Test
    fun `getDetailsCommunityTest returns community details object`() {
        val communityDetails = useCase.execute()
        assertNotNull(communityDetails)
    }
}