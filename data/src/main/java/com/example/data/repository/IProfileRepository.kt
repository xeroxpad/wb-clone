package com.example.data.repository

import com.example.domain.entities.Person
import com.example.domain.repository.ProfileRepository

class IProfileRepository: ProfileRepository {
    override fun getDataProfileUseCase(): Person = mockPersonData

    private val mockPersonData = Person(
        id = 1,
        name = "Михаил",
        secondName = "Никонов",
        numberPhone = "+7 999 999-99-99",
        avatarUrl = "https://i.pinimg.com/originals/89/e5/8e/89e58e371fded01e2ccf40fdea5c2c4d.jpg",
        socialMediaIcons = listOf()
    )
}