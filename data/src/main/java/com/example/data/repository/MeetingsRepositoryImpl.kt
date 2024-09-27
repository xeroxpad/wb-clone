package com.example.data.repository

import com.example.domain.entities.FixEvent
import com.example.domain.entities.FixMeetingsDescription
import com.example.domain.repository.IMeetingsRepository
import io.bloco.faker.Faker

class MeetingsRepositoryImpl : IMeetingsRepository {
    override fun getMeetings(): List<FixEvent> {
        return mockMeetings()
    }

    override fun getDescriptionMeetings(): FixMeetingsDescription = mockMeetingsDescriptionData

    private val faker = Faker()
    private fun mockMeetings(): List<FixEvent> {
        return listOf(
            FixEvent(
                id = 1,
                icon = "https://api.multiavatar.com/${faker.number.between(1, 1000)}.png",
                title = faker.name.title(),
                date = "13.09.2024",
                city = faker.address.streetAddress(),
                tagDevelopmentLanguage = faker.lorem.word().uppercase(),
                tagGradeDeveloper = faker.lorem.word().uppercase(),
                tagCityMeeting = faker.lorem.word().uppercase(),
            ),
            FixEvent(
                id = 2,
                icon = "https://api.multiavatar.com/${faker.number.between(1, 1000)}.png",
                title = faker.name.title(),
                date = "13.09.2024",
                city = faker.address.streetAddress(),
                tagDevelopmentLanguage = faker.lorem.word().uppercase(),
                tagGradeDeveloper = faker.lorem.word().uppercase(),
                tagCityMeeting = faker.lorem.word().uppercase(),
            ),FixEvent(
                id = 3,
                icon = "https://api.multiavatar.com/${faker.number.between(1, 1000)}.png",
                title = faker.name.title(),
                date = "13.09.2024",
                city = faker.address.streetAddress(),
                tagDevelopmentLanguage = faker.lorem.word().uppercase(),
                tagGradeDeveloper = faker.lorem.word().uppercase(),
                tagCityMeeting = faker.lorem.word().uppercase(),
            ),FixEvent(
                id = 4,
                icon = "https://api.multiavatar.com/${faker.number.between(1, 1000)}.png",
                title = faker.name.title(),
                date = "13.09.2024",
                city = faker.address.streetAddress(),
                tagDevelopmentLanguage = faker.lorem.word().uppercase(),
                tagGradeDeveloper = faker.lorem.word().uppercase(),
                tagCityMeeting = faker.lorem.word().uppercase(),
            )
        )
    }

//        listOf(
//            FixEvent(
//                id = 41,
//                icon = "https://s3-alpha-sig.figma.com/img/9e0b/4653/93a4987dcdd3d4a37afdd74a85ee4518?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=aA8JbMQaG4VDlQ53SC~4kmAhbCSLyDsJ~tFzu9rv5ecxZLo4W7ke47thxwMFFooJz80g5CgwTw9KdRNgtPT4DFaNUHbiELf5tj3yuDpMkCG-qL7gRF2hHiA9oSyo2qeBiBVZ0cqosd36JnZRHX0UoqeUiXCkX9dqI74Hxs~JL~SXxPqTUKZpusBXUOvBacBhLnhyyia5h11Qd86gRsIZ7Vdb5H4mUIIqlY96lhxTh-CNRSSLC4N3RI82kzxMqvOmdUGatANqAgKQD-zBqtGxEoapHu6Vm5Us-d1Rg~MkldjTvWOnoKDGwFojZJMOn2YTw0ist8hYDJ4A48CsApuzMQ__",
//                title = "QA Talks — Global tech forum",
//                date = "Завтра",
//                city = "Невский проспект, 11",
//                tagDevelopmentLanguage = "Тестирование",
//                tagGradeDeveloper = "Разработка",
//                tagCityMeeting = "Backend",
//            ),
//            FixEvent(
//                id = 42,
//                icon = "https://s3-alpha-sig.figma.com/img/6b64/81ed/b055df872dc3eb48d1b88d2fbdc47dd9?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=WlZvqaoJ6Xp2XNdkwSqy7hsLDUMc4UbJRBlUWjwJk6BherKLqCAG5vwDeqsgDoMRCGa3CYdLFKm-YotRRNKwOGAGi2htig1Kd37wzRyNwnuR-2BiMDnSnTJAJZvknPXRQTB2uO5QIKT~vPab853sMmLbTKApSSnoB-XwCF-Z7JeM6a~6FlWUyR~lCrf6dnzyONIVoL06ODVZOJrweU6SbuMZs66-G1ZP6MNN4sknS95Yh5M59A~LiL7oFv9cR2-0UyvDP5j2irREaUwMwOod-Sn09LyvUvS3LPzeTdO8Mdr8-De2mMEyBNfJt6cSPubTNrVWcPJTeOGjsRXX3H6-mw__",
//                title = "Python days 2024",
//                date = "13.09.2024",
//                city = "Санкт-Петербург",
//                tagDevelopmentLanguage = "Kotlin",
//                tagGradeDeveloper = "Junior",
//                tagCityMeeting = "SPB",
//            ),
//            FixEvent(
//                id = 43,
//                icon = "https://imsts.com/sites/default/files/md-slider-image/sl-7-ims-event-staging-scenic-design.jpg",
//                title = "Турнир разработчиков «Белые Ночи»",
//                date = "13.09.2024",
//                city = "Москва",
//                tagDevelopmentLanguage = "Kotlin",
//                tagGradeDeveloper = "Junior",
//                tagCityMeeting = "Moscow",
//            ),
//            FixEvent(
//                id = 44,
//                icon = "https://s3-alpha-sig.figma.com/img/1e90/ce78/0f37865722ee6b6927715576f9352a79?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=jDgiboUkjPpqlt6vfoV521~IdxncqRb6zW8aCIzlOB~YDI9tN39RfC-0CWoMXsDKMR~7Y2t7xRdhXWUPt1s2KlUAU-J9ySDIwA5vDKTFnCMAeqtfJ3VKWpYgCuNPuKcc1iEyh9lP7NTy7AjpPTcAAix2NOetYXllYEw0lyDRSiJFOJrk06XPw8vUwXtGP4TH0CZyumValK~Z3vkz1dOc~MOffHNhccFOCbqdnPJWDpT-0CKUgaMzQXLQ5kc~kaMk3vzMPoDLILZb7wWn6fYBiB7iz1jv8IdNpXeKm4Z5IJ~SpQDQDgL3AxkGjji-d4-Q~~dTy-W~o1OvPEN8bcZAqA__",
//                title = "Геймдев на нейросетях. Лекция Станислава Макарова",
//                date = "13.09.2024",
//                city = "Казань",
//                tagDevelopmentLanguage = "Kotlin",
//                tagGradeDeveloper = "Junior",
//                tagCityMeeting = "Kazan",
//            ),
//            FixEvent(
//                id = 45,
//                icon = "https://s3-alpha-sig.figma.com/img/926a/1f99/7b21b0dc7828119549b597bdd99ebdba?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=X2m94-9epqCYTUxHBMCwIpDK~pypTEVvk8n5bkfacIYxR0tJ5fph-z9n5OYpY5s5TlLqQVZO-Az4jpOuwEfBCegE9Kk0me66VKVspsIVSANKGXYHFAfyg4Wmm3PB8xTyZYNaDNN8JbWsSq4FH72hVuUxBa89HmOnNwRc8Bp6~Fim8ozraDARLmS4TQk4Ewzb34aj6oxyO-Khjut12IlZDsvIpS-vcaABONvAwQIa445Lb-T~-gar8EcnFnuuKAAaRtB5gc6iPklJOG-cyfxUsvmYYmwY1ReQB9vvGPxZrvU4-TXjv3hW9L4uqc~HC~Ry6DSLlZcQlJXmBhY0S77~Kw__",
//                title = "QA Talks — Global tech forum",
//                date = "13.09.2024",
//                city = "Москва",
//                tagDevelopmentLanguage = "Kotlin",
//                tagGradeDeveloper = "Junior",
//                tagCityMeeting = "Moscow",
//            ),
//            FixEvent(
//                id = 46,
//                icon = "https://imsts.com/sites/default/files/md-slider-image/sl-7-ims-event-staging-scenic-design.jpg",
//                title = "Feature-Sliced Design 2024",
//                date = "13.09.2024",
//                city = "Уфа",
//                tagDevelopmentLanguage = "Kotlin",
//                tagGradeDeveloper = "Junior",
//                tagCityMeeting = "Ufa",
//            ),
//            FixEvent(
//                id = 47,
//                icon = "https://s3-alpha-sig.figma.com/img/3f76/bf34/17607a249f9392e5e42d065853a96234?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Zj-JXLzkoAJ7bHbhJRV2yeM9XJFfqOe0IaiARy54ls3eFpQ2OxRxc4~OPne1OTYUYk7GgsHdAi33HVFP3xuuJ6WAAqJ9hVw2d6Qd9prbhI7pH8whhykntdRLBm6dw9D~c0DMZ~dVo1qMciei0CW4y1WiqWFy~CJk1qpMbG-W1~vt4~dH8b0VPj5viCqcqd-qqfGYRcbZLgeuKki2VG38ZSheozXZfLC5svl0y61ifVdafZeADhhmIkO2qjvjTUpexr87FkSZyAThnww30Jw7gIH5NhmqHaoFM~41cd12BnF3mS0HfmW4-x~vAoyuSJbpkZql-LzV0y7XGgQ33ATldw__",
//                title = "Front talks",
//                date = "13.09.2024",
//                city = "Москва",
//                tagDevelopmentLanguage = "Kotlin",
//                tagGradeDeveloper = "Junior",
//                tagCityMeeting = "Moscow",
//            ),
//            FixEvent(
//                id = 48,
//                icon = "https://s3-alpha-sig.figma.com/img/6628/4667/de716b625c9b62f9cfbbe42ebb67e0fd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=l1l5061aZnM31Vg7PDCmIUNNtlDF~DI94FvQHor0l~zSmqDzu9fX5JsPoN89Y1zFhcKAmi~BfZdiyXK3YYS375qymRGKVrG5vNdc8zNlOpxe8PvAQSINOdCFYl5j27V-iSyD2il7O~XiZtmbmFtrh807f94GATBArj4D-e1-2hD98MjztLDgBQzeBdO5J5YJNlT-c5xc246~2bXtRR~Qx8nlw~zUjH58AniTJdJaWuefMf4sly3XNdE1tC87V-CPUrJj2Dkj0rxQbYhDWNoimqMbP2UB~qrg2BWm3BTuw~XvbTN-ht-uvUCNBqE1uihDQSMbW7zfvNEzVQUp791qqw__",
//                title = "Как повышать грейд. Лекция ПавлаХорикова",
//                date = "13.09.2024",
//                city = "Москва",
//                tagDevelopmentLanguage = "Kotlin",
//                tagGradeDeveloper = "Junior",
//                tagCityMeeting = "Moscow",
//            ),
//        )

    val mockMeetingsDescriptionData =
//        MeetingsDescription(
//            id = 1,
//            title = "Как повышать грейд. Лекция Павла Хорикова",
//            dateAndLocation = "16 августа, 16:00 · Кожевенная линия, 40",
//            tags = listOf("Маркетинг", "Бизнес", "Продажи"),
//            map = "https://yandex.ru/images/search?cbir_id=2182879%2FOCIzHqQdm3jcJPjJsSRIBQ365&cbir_page=similar&cbird=152&img_url=https%3A%2F%2Favatars.dzeninfra.ru%2Fget-zen_doc%2F271828%2Fpub_65c9e1ad34fdc3328d4ac2dd_65c9e1c434fdc3328d4acbb7%2Fscale_1200&lr=21639&pos=3&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F2182879%2FOCIzHqQdm3jcJPjJsSRIBQ365%2Forig",
//            description =
//            "Узнайте, как расти в профессии, улучшать навыки и получать повышение. Практические советы и реальные кейсы.\n" +
//                    "Павел поделится эффективными стратегиями карьерного роста и методикой развития профессиональных навыков в IT.",
//            rowAvatars =
//            listOf(
//                "https://picsum.photos/200/300?random",
//                "https://picsum.photos/200/300?random",
//                "https://picsum.photos/200/300?random",
//                "https://picsum.photos/200/300?random",
//            ),
//        )

        FixMeetingsDescription(
            idMeeting = 1,
            titleMeeting = faker.name.title(),
            avatarUrlMeeting = "https://picsum.photos/500/500?random",
            dateMeeting = "16 августа",
            timeMeeting = "16:00",
            locationMeeting = "Кожевенная улица, 40",
            tagsMeeting = "Бизнес",
            descriptionMeeting = "Узнайте, как расти в профессии, улучшать навыки и получать повышение. Практические советы и реальные кейсы." +
                    "Павел поделится эффективными стратегиями карьерного роста и методикой развития профессиональных навыков в IT.",
            leaderMeeting = "Павел Хориков",
            leaderInfoMeeting = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
            leaderAvatar = "https://picsum.photos/500/500?random",
            iconMetroStation = "",
            titleMetroStation = "Приморская",
            mapMeeting = "https://picsum.photos/500/500?random",
            visitorsMeeting = listOf(
                "https://api.multiavatar.com/${
                    faker.number.between(
                        1,
                        1000
                    )
                }.png",
                "https://api.multiavatar.com/${faker.number.between(1, 1000)}.png",
                "https://api.multiavatar.com/${faker.number.between(1, 1000)}.png"
            ),
            titleCommunityMeeting = "The IT Crowd",
            isSubscribedCommunity = true,
            descriptionCommunityMeeting = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
            iconCommunityMeeting = "https://picsum.photos/500/500?random",
            otherMeetingCommunity = FixEvent(
                id = 1,
                icon = "https://picsum.photos/500/500?random",
                title = faker.name.title(),
                date = "13.09.2024",
                city = faker.address.streetAddress(),
                tagDevelopmentLanguage = faker.lorem.word().uppercase(),
                tagGradeDeveloper = faker.lorem.word().uppercase(),
                tagCityMeeting = faker.lorem.word().uppercase(),
            ),
        )
}
