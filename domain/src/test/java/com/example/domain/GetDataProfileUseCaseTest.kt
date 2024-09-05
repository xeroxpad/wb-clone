package com.example.domain

import com.example.domain.repository.ProfileRepositoryTestStub
import com.example.domain.usecases.GetDataProfileUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

internal class GetDataProfileUseCaseTest {
    private lateinit var repoProfile: ProfileRepositoryTestStub
    private lateinit var useCase: GetDataProfileUseCase

    @Before
    fun setUp() {
        repoProfile = ProfileRepositoryTestStub()
        useCase = GetDataProfileUseCase(repoProfile)
    }

    @Test
    fun `getDataProfileUseCase returns profile correct id`() {
        val expectedId = 1
        val profile = useCase.execute()
        assertEquals(expectedId, profile.id)
    }

    @Test
    fun `getDataProfileUseCase returns profile valid data`() {
        val profile = useCase.execute()
        assertNotNull("id не null", profile.id)
        assertTrue("id типа Int", profile.id is Int)

        assertNotNull("name не null", profile.name)
        assertTrue("name типа String", profile.name is String)

//        if (profile.secondName != null) {
//            assertTrue("secondName типа String", profile.secondName is String)
//        } else {
//            assertNull("secondName null", profile.secondName)
//        }

//        assertNotNull("numberPhone не null", profile.numberPhone)
//        assertTrue("nuberPhone типа String", profile.numberPhone is String)

        if (profile.avatarUrl != null) {
            assertTrue("avatarUrl типа String", profile.avatarUrl is String)
        } else {
            assertNull("avatarUrl null", profile.avatarUrl)
        }

//        assertNotNull("socialMediaIcons не null", profile.socialMediaIcons)
//        assertTrue("socialMediaIcons типа String", profile.socialMediaIcons is List<String>)
    }
}
