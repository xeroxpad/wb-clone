package com.example.domain.repository

import com.example.domain.entities.FixPerson
import com.example.domain.entities.Person

class ProfileRepositoryTestStub : IProfileRepository {
    //    override fun getDataProfileUseCase(): Person = mockPersonData
    override fun getDataProfileUseCase(): FixPerson = mockPersonData

    private val mockPersonData =
//        Person(
//            id = 1,
//            name = "Михаил",
//            secondName = "Никонов",
//            numberPhone = "+7 999 999-99-99",
//            avatarUrl = "https://i.pinimg.com/originals/89/e5/8e/89e58e371fded01e2ccf40fdea5c2c4d.jpg",
//            socialMediaIcons = listOf(),
//        )
        FixPerson(
            id = 1,
            name = "Михаил",
            avatarUrl = "https://i.pinimg.com/originals/89/e5/8e/89e58e371fded01e2ccf40fdea5c2c4d.jpg",
            interests = "Разработка"
        )

}
