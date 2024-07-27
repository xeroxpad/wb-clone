package com.example.domain

import com.example.domain.repository.CommunityRepository
import com.example.domain.repository.ICommunityRepositoryTest
import org.junit.Assert.assertFalse
import org.junit.Test

class GetAllCommunityUseCaseTest {
    private val repoCommunity: CommunityRepository = ICommunityRepositoryTest()
    @Test
    fun `getAllCommunityTest returns correct community`() {
        val allCommunity = repoCommunity.getAllCommunity()
        assertFalse(allCommunity.isEmpty())
    }
}