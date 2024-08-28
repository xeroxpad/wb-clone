package com.example.data.repository

import com.example.domain.entities.FixPerson
import com.example.domain.entities.Person
import com.example.domain.repository.IProfileRepository
import java.net.URI

class ProfileRepositoryImpl : IProfileRepository {
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
            name = "Анастасия",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/c6dc/9a5b/9cc40897f19e46b907399c8755e1f9ea?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=KXY33iKlvcs2fRDt7z2ymePeIpxUOpvcJRd4xoeeIY6mOlF~dv9u7memTOnKDqPd-YXFo77Wc8~IhmaL1wWdzscyHSOYIpDsvZwxdN5CGZC5zQrjlefxAU6sQ54sFnxsCdpO-rwCCqzn2mNc-nUcksbZpmTKmwPacnwjwZIoXXjGvtI~fmUYSMiyGH7NtTon0KePWgf~Z~yIIQAqPGA5tfqltU7yx4o5aFh5b9PLnUddsnl-JG2Whah9B7~mUcyL3Fcy~q49IzZRNUJT3fq4KI91Ii0LxDrohLeS7quDtjmES-wc0Br2fl5tsY9sdEBiJNY3o7HRx1RQwUPAiRZp6w__",
            interests = "Дизайн"
        )
}
