package com.example.data.repository

import com.example.domain.entities.Meetings
import com.example.domain.entities.MeetingsDescription
import com.example.domain.repository.MeetingsRepository

class IMeetingsRepository: MeetingsRepository {
    override fun getMeetings(): List<Meetings> = mockMeetings

    override fun getDescriptionMeetings(): MeetingsDescription = mockMeetingsDescriptionData
    val mockMeetings = listOf(
        Meetings(
            id = 41,
            icon = "https://thumbs.dreamstime.com/b/minimalist-twin-coffee-code-logo-design-template-163374058.jpg",
            title = "Developer Meetings",
            date = "13.09.2024",
            city = "Москва",
            tagDevelopmentLanguage = "Kotlin",
            tagGradeDeveloper = "Junior",
            tagCityMeeting = "Moscow"
        ),
        Meetings(
            id = 42,
            icon = "https://avatars.mds.yandex.net/i?id=bf8f0894fce7ad1264fe8fcc7a7f89c545350bb0-4055370-images-thumbs&n=13",
            title = "Developer Meetings",
            date = "13.09.2024",
            city = "Санкт-Петербург",
            tagDevelopmentLanguage = "Kotlin",
            tagGradeDeveloper = "Junior",
            tagCityMeeting = "SPB"
        ),
        Meetings(
            id = 43,
            icon = "https://thumbs.dreamstime.com/b/дизайн-логотипа-coffee-code-может-быть-использован-в-качестве-значка-знака-224274224.jpg",
            title = "Developer Meetings",
            date = "13.09.2024",
            city = "Москва",
            tagDevelopmentLanguage = "Kotlin",
            tagGradeDeveloper = "Junior",
            tagCityMeeting = "Moscow"
        ),
        Meetings(
            id = 44,
            icon = "https://avatars.mds.yandex.net/i?id=bf8f0894fce7ad1264fe8fcc7a7f89c545350bb0-4055370-images-thumbs&n=13",
            title = "Developer Meetings",
            date = "13.09.2024",
            city = "Казань",
            tagDevelopmentLanguage = "Kotlin",
            tagGradeDeveloper = "Junior",
            tagCityMeeting = "Kazan"
        ),
        Meetings(
            id = 45,
            icon = "https://thumbs.dreamstime.com/b/дизайн-логотипа-coffee-code-может-быть-использован-в-качестве-значка-знака-224274224.jpg",
            title = "Developer Meetings",
            date = "13.09.2024",
            city = "Москва",
            tagDevelopmentLanguage = "Kotlin",
            tagGradeDeveloper = "Junior",
            tagCityMeeting = "Moscow"
        ),
        Meetings(
            id = 46,
            icon = "https://thumbs.dreamstime.com/b/minimalist-twin-coffee-code-logo-design-template-163374058.jpg",
            title = "Developer Meetings",
            date = "13.09.2024",
            city = "Уфа",
            tagDevelopmentLanguage = "Kotlin",
            tagGradeDeveloper = "Junior",
            tagCityMeeting = "Ufa"
        ),
        Meetings(
            id = 47,
            icon = "https://thumbs.dreamstime.com/b/дизайн-логотипа-coffee-code-может-быть-использован-в-качестве-значка-знака-224274224.jpg",
            title = "Developer Meetings",
            date = "13.09.2024",
            city = "Москва",
            tagDevelopmentLanguage = "Kotlin",
            tagGradeDeveloper = "Junior",
            tagCityMeeting = "Moscow"
        ),
        Meetings(
            id = 48,
            icon = "https://avatars.mds.yandex.net/i?id=bf8f0894fce7ad1264fe8fcc7a7f89c545350bb0-4055370-images-thumbs&n=13",
            title = "Developer Meetings",
            date = "13.09.2024",
            city = "Москва",
            tagDevelopmentLanguage = "Kotlin",
            tagGradeDeveloper = "Junior",
            tagCityMeeting = "Moscow"
        ),
    )

    val mockMeetingsDescriptionData = MeetingsDescription(
        id = 1,
        title = "Meeting Description",
        dateAndLocation = "13.10.2024 - Москва",
        tags = listOf("Kotlin", "Junior", "Moscow"),
        map = "https://yandex.ru/images/search?cbir_id=2182879%2FOCIzHqQdm3jcJPjJsSRIBQ365&cbir_page=similar&cbird=152&img_url=https%3A%2F%2Favatars.dzeninfra.ru%2Fget-zen_doc%2F271828%2Fpub_65c9e1ad34fdc3328d4ac2dd_65c9e1c434fdc3328d4acbb7%2Fscale_1200&lr=21639&pos=3&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F2182879%2FOCIzHqQdm3jcJPjJsSRIBQ365%2Forig",
        description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\n" +
                "Volutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh molestie faucibus sit mi risus eget. Vivamus dolor ac tortor nibh. Metus amet odio id magna. Augue ac commodo sem varius purus eros eu pharetra nec.\n" +
                "Bibendum eget donec senectus turpis massa. Magna nunc diam pellentesque egestas sit auctor. Ullamcorper placerat blandit eget scelerisque adipiscing nisi tellus. Aliquam aliquet arcu diam cursus. Egestas duis tellus etiam molestie imperdiet. Tellus turpis purus ligula odio at facilisi. Felis sed in adipiscing ut et amet eros at. Tortor tempor habitasse molestie sed enim condimentum. Purus tellus nec lacus nisl eu sit venenatis elit. Nunc at lacus sit iaculis et volutpat. Elit id vulputate non sed placerat neque parturient egestas. Proin pellentesque bibendum volutpat adipiscing sagittis habitant elit.\n" +
                "Odio justo dignissim ullamcorper purus ullamcorper sit semper dictum. Tortor est mauris aliquet amet sit ultrices auctor nulla. Faucibus aliquam etiam pharetra pellentesque sagittis odio lacus. Eu morbi senectus in massa fermentum elit in. Tincidunt est blandit malesuada auctor. Orci tellus mus aliquam accumsan ac. Et urna nisl facilisis non volutpat et sodales.\n" +
                "Malesuada egestas enim purus cras diam eget vel. Massa ante sit scelerisque scelerisque hac. Consequat tempor non pretium convallis. Interdum iaculis sit interdum interdum magna. Gravida urna et cursus donec consectetur nulla. Aliquet egestas nulla arcu aliquam facilisi duis maecenas viverra. Egestas consectetur mauris orci sit. Bibendum orci at viverra pharetra tortor nulla amet erat vehicula. Mauris volutpat amet in sit rhoncus. Imperdiet feugiat id fames gravida.",
        rowAvatars = listOf(
            "https://img.freepik.com/free-photo/river-surrounded-by-forests-under-a-cloudy-sky-in-thuringia-in-germany_181624-30863.jpg?w=2000&t=st=1721590773~exp=1721591373~hmac=8bafe832f555c2d27e0eb6104a156a05517526716799a7f7329d7a3ed3ad5fda",
            "https://img.freepik.com/free-photo/view-of-beautiful-rainbow-over-nature-landscape_23-2151597605.jpg?w=1800&t=st=1721590788~exp=1721591388~hmac=8271a7c5930c7fdb083c5e7320c77c065cf369231c67a0d023285f352a3118ee",
            "https://img.freepik.com/free-photo/mountains-lake_1398-1153.jpg?w=1800&t=st=1721590799~exp=1721591399~hmac=d0f17dbaba1f0dfe86eb81e1ea40e8411da39d0fe3e87343773c74a7381dca05",
            "https://img.freepik.com/free-photo/vertical-landscape-with-mountains-lake_1398-3441.jpg?w=1800&t=st=1721590816~exp=1721591416~hmac=57c4ee8e445680e70baea9e6f29a83a917b0579ad40193b0b18396bac22220f6",
            "https://img.freepik.com/free-photo/photorealistic-tree-with-branches-and-trunk-outside-in-nature_23-2151478150.jpg?w=1800&t=st=1721590832~exp=1721591432~hmac=0c503568d6e3f627ece66975db2c1c11b2af0daa91c59012c5592c388279c583",
            "https://img.freepik.com/free-photo/photorealistic-tree-with-branches-and-trunk-outside-in-nature_23-2151478150.jpg?w=1800&t=st=1721590832~exp=1721591432~hmac=0c503568d6e3f627ece66975db2c1c11b2af0daa91c59012c5592c388279c583"
        )
    )
}