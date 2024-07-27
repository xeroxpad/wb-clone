package com.example.domain.repository

import com.example.domain.entities.Person

class IProfileRepositoryTest: ProfileRepository {
    override fun getDataProfileUseCase(): Person = mockPersonData

    private val mockPersonData = Person(
        name = "Михаил",
        secondName = "Никонов",
        numberPhone = "+7 999 999-99-99",
        avatarUrl = "https://i.pinimg.com/originals/89/e5/8e/89e58e371fded01e2ccf40fdea5c2c4d.jpg",
        socialMediaIcons = listOf()
    )
}