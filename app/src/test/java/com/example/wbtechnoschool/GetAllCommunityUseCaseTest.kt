package com.example.wbtechnoschool

import com.example.data.repository.ICommunityRepository
import com.example.domain.repository.CommunityRepository
import org.junit.Assert.assertFalse
import org.junit.Test


class GetAllCommunityUseCaseTest {
    private val repoCommunity: CommunityRepository = ICommunityRepository()
    @Test
    fun `getAllCommunityTest returns correct community`() {
        val allCommunity = repoCommunity.getAllCommunity()
        assertFalse(allCommunity.isEmpty())
    }
}