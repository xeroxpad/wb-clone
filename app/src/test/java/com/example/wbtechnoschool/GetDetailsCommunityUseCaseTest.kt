package com.example.wbtechnoschool

import com.example.data.repository.ICommunityRepository
import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.GetDetailsCommunityUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class GetDetailsCommunityUseCaseTest {
    private val repoCommunity: CommunityRepository = ICommunityRepository()
    private val useCase: GetDetailsCommunityUseCase = GetDetailsCommunityUseCase(repoCommunity)
    @Test
    fun `getDetailsCommunityTest returns community details correct id`() {
        val expectedCommunityID = 1
        val actualCommunityDetails = useCase.execute()
        assertEquals(expectedCommunityID, actualCommunityDetails.id)
    }
}