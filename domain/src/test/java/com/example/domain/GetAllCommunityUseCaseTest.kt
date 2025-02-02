package com.example.domain

import com.example.domain.repository.CommunityRepositoryTestStub
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class GetAllCommunityUseCaseTest {
    private val repoCommunity = CommunityRepositoryTestStub()
    @Test
    fun `getAllCommunityTest returns not empty`() {
        val allCommunity = repoCommunity.getAllCommunity()
        assertFalse("список не пустой",allCommunity.isEmpty())
    }

    @Test
    fun `getAllCommunityTest returns valid data`() {
        val allCommunity = repoCommunity.getAllCommunity()
        for (community in allCommunity) {
            assertNotNull("id не null", community.id)
            assertTrue("id типа Int", community.id is Int)

            if (community.icon != null) {
                assertTrue("icon типа String", community.icon is String)
            } else {
                assertNull("icon null", community.icon)
            }

            assertNotNull("title не null", community.title)
            assertTrue("title типа String", community.title is String)

            if (community.countPersons != null) {
                assertTrue("countPersons типа String", community.countPersons is String)
            } else {
                assertNull("countPersons null", community.countPersons)
            }
        }
    }
}