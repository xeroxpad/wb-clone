package com.example.domain.usecases

import com.example.domain.entities.Community
import com.example.domain.entities.CommunityDetails
import com.example.domain.repository.CommunityRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestRepo : CommunityRepository {
    override fun getAllCommunity(): List<Community> {
        return List(9) { index ->
            Community(
                id = index,
                icon = "https://example.com/icon$index.png",
                title = "Community $index",
                countPersons = "${index * 10} persons"
            )
        }
    }

    override fun getDetailsCommunity(): CommunityDetails {
        TODO("Not yet implemented")
    }

}

class GetAllCommunityUseCaseTest {
    private val testRepo = TestRepo()
    private val useCase = GetAllCommunityUseCase(repository = testRepo)

    @Test
    fun `should return correct number of communities`() {
        val communities = useCase.execute()
        assertEquals(10, communities.size)
    }

    @Test
    fun `should return correct community data`() {
        val communities = useCase.execute()

        assertEquals(0, communities[0].id)
        assertEquals("https://example.com/icon0.png", communities[0].icon)
        assertEquals("Community 0", communities[0].title)
        assertEquals("0 persons", communities[0].countPersons)

        assertEquals(9, communities[9].id)
        assertEquals("https://example.com/icon9.png", communities[9].icon)
        assertEquals("Community 9", communities[9].title)
        assertEquals("90 persons", communities[9].countPersons)
    }
}