package com.example.data.repository

import com.example.domain.entities.Community
import com.example.domain.entities.CommunityDetails
import com.example.domain.entities.FixEvent
import com.example.domain.entities.Meetings
import com.example.domain.repository.ICommunityRepository

class CommunityRepositoryImpl : ICommunityRepository {
    override fun getAllCommunity(): List<Community> = mockCommunityData

    override fun getDetailsCommunity(): CommunityDetails = mockCommunityDetails

    val mockCommunityData =
        listOf<Community>(
            Community(
                id = 0,
                icon = null,
                title = "Яндекс",
                countPersons = null,
            ),
            Community(
                id = 1,
                icon = "https://weldtex.ru/wp-content/uploads/2024/01/ozon.png",
                title = "Озон",
                countPersons = "1 000 человек",
            ),
            Community(
                id = 2,
                icon = "https://avoshop.ru/upload/iblock/a8a/9gldo5wx1d1xngaj5m71b2c77ybz5tku.png",
                title = "Wildberries",
                countPersons = "100 000 человек",
            ),
            Community(
                id = 3,
                icon = "https://oscomp.ru/upload/iblock/b53/lmuwr5qb16y6bwiezy24zgty95zaf1ud.png",
                title = "Huawei",
                countPersons = "50 000 человек",
            ),
            Community(
                id = 4,
                icon = "https://u.9111s.ru/uploads/202206/09/c5e55d54ff5036ff6b09a378bad27c21.png",
                title = "Apple",
                countPersons = "5 000 человек",
            ),
            Community(
                id = 5,
                icon = "https://tehnomir71.ru/upload/iblock/c11/c113e3db6aa18e7cd34b5433b457deb0.jpg",
                title = "Samsung",
                countPersons = "3 000 человек",
            ),
            Community(
                id = 6,
                icon = "https://strogino.mos.ru/upload/medialibrary/005/cn52sgfb49fyxdslyf98hqx7lff63fbs/800px_Vk_logo.svg.png",
                title = "VK",
                countPersons = "1 000 человек",
            ),
            Community(
                id = 7,
                icon = "https://retrobloha.ru/naborspichek20let/images/g0ea0GZ5LXR_h1NrOrBGDWOQ0oQ=/1199x/ff0b8095-4519-49f1-af84-035d53966dea.png",
                title = "Avito",
                countPersons = "100 человек",
            ),
            Community(
                id = 8,
                icon = "https://pochemu-ne-rabotaet.ru/wp-content/uploads/2022/09/ламода.jpg",
                title = "Lamoda",
                countPersons = "20 000 человек",
            ),
            Community(
                id = 9,
                icon = "https://geekville.ru/wp-content/uploads/2023/08/1-43.jpg",
                title = "МТС",
                countPersons = "2 000 человек",
            ),
            Community(
                id = 10,
                icon = "https://rendercar.ru/wp-content/uploads/2023/03/tinkoff-logo.png",
                title = "Тинькофф",
                countPersons = "5 000 человек",
            ),
        )

    val mockMeetingsData =
        listOf(
            FixEvent(
                id = 31,
                icon = "https://ya.ru/images/search?cbir_id=1030127%2FXX-XP__jWg71DdsD82BnZA329&cbir_page=similar&crop=0.016%3B0.016%3B0.984%3B0.984&img_url=https%3A%2F%2Fstatic.ngs.ru%2Fnews%2F99%2Fpreview%2F2c81a1e4b696c665e3f6e03d7ea5113d03c8ea71_9999.jpg&lr=21639&pos=0&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F1030127%2FXX-XP__jWg71DdsD82BnZA329%2Forig",
                title = "QA Talks — Global tech forum",
                date = "Завтра",
                city = "Невский проспект, 11",
                tagDevelopmentLanguage = "Kotlin",
                tagGradeDeveloper = "Junior",
                tagCityMeeting = "Moscow",
            ),
            FixEvent(
                id = 33,
                icon = "https://ya.ru/images/search?cbir_id=1030127%2FXX-XP__jWg71DdsD82BnZA329&cbir_page=similar&crop=0.016%3B0.016%3B0.984%3B0.984&img_url=https%3A%2F%2Fstatic.ngs.ru%2Fnews%2F99%2Fpreview%2F2c81a1e4b696c665e3f6e03d7ea5113d03c8ea71_9999.jpg&lr=21639&pos=0&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F1030127%2FXX-XP__jWg71DdsD82BnZA329%2Forig",
                title = "QA Talks — Global tech forum",
                date = "13.09.2024",
                city = "Невский проспект, 11",
                tagDevelopmentLanguage = "Kotlin",
                tagGradeDeveloper = "Junior",
                tagCityMeeting = "SPB",
            ),
            FixEvent(
                id = 33,
                icon = "https://ya.ru/images/search?cbir_id=1030127%2FXX-XP__jWg71DdsD82BnZA329&cbir_page=similar&crop=0.016%3B0.016%3B0.984%3B0.984&img_url=https%3A%2F%2Fstatic.ngs.ru%2Fnews%2F99%2Fpreview%2F2c81a1e4b696c665e3f6e03d7ea5113d03c8ea71_9999.jpg&lr=21639&pos=0&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F1030127%2FXX-XP__jWg71DdsD82BnZA329%2Forig",
                title = "Developer Meetings",
                date = "13.09.2024",
                city = "Невский проспект, 11",
                tagDevelopmentLanguage = "Kotlin",
                tagGradeDeveloper = "Junior",
                tagCityMeeting = "Moscow",
            ),
            FixEvent(
                id = 34,
                icon = "https://ya.ru/images/search?cbir_id=1030127%2FXX-XP__jWg71DdsD82BnZA329&cbir_page=similar&crop=0.016%3B0.016%3B0.984%3B0.984&img_url=https%3A%2F%2Fstatic.ngs.ru%2Fnews%2F99%2Fpreview%2F2c81a1e4b696c665e3f6e03d7ea5113d03c8ea71_9999.jpg&lr=21639&pos=0&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F1030127%2FXX-XP__jWg71DdsD82BnZA329%2Forig",
                title = "Developer Meetings",
                date = "13.09.2024",
                city = "Казань",
                tagDevelopmentLanguage = "Kotlin",
                tagGradeDeveloper = "Junior",
                tagCityMeeting = "Kazan",
            ),
            FixEvent(
                id = 35,
                icon = "https://ya.ru/images/search?cbir_id=1030127%2FXX-XP__jWg71DdsD82BnZA329&cbir_page=similar&crop=0.016%3B0.016%3B0.984%3B0.984&img_url=https%3A%2F%2Fstatic.ngs.ru%2Fnews%2F99%2Fpreview%2F2c81a1e4b696c665e3f6e03d7ea5113d03c8ea71_9999.jpg&lr=21639&pos=0&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F1030127%2FXX-XP__jWg71DdsD82BnZA329%2Forig",
                title = "Developer Meetings",
                date = "13.09.2024",
                city = "Москва",
                tagDevelopmentLanguage = "Kotlin",
                tagGradeDeveloper = "Junior",
                tagCityMeeting = "Moscow",
            ),
            FixEvent(
                id = 36,
                icon = "https://ya.ru/images/search?cbir_id=1030127%2FXX-XP__jWg71DdsD82BnZA329&cbir_page=similar&crop=0.016%3B0.016%3B0.984%3B0.984&img_url=https%3A%2F%2Fstatic.ngs.ru%2Fnews%2F99%2Fpreview%2F2c81a1e4b696c665e3f6e03d7ea5113d03c8ea71_9999.jpg&lr=21639&pos=0&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F1030127%2FXX-XP__jWg71DdsD82BnZA329%2Forig",
                title = "Developer Meetings",
                date = "13.09.2024",
                city = "Уфа",
                tagDevelopmentLanguage = "Kotlin",
                tagGradeDeveloper = "Junior",
                tagCityMeeting = "Ufa",
            ),
            FixEvent(
                id = 37,
                icon = "https://ya.ru/images/search?cbir_id=1030127%2FXX-XP__jWg71DdsD82BnZA329&cbir_page=similar&crop=0.016%3B0.016%3B0.984%3B0.984&img_url=https%3A%2F%2Fstatic.ngs.ru%2Fnews%2F99%2Fpreview%2F2c81a1e4b696c665e3f6e03d7ea5113d03c8ea71_9999.jpg&lr=21639&pos=0&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F1030127%2FXX-XP__jWg71DdsD82BnZA329%2Forig",
                title = "Developer Meetings",
                date = "13.09.2024",
                city = "Москва",
                tagDevelopmentLanguage = "Kotlin",
                tagGradeDeveloper = "Junior",
                tagCityMeeting = "Moscow",
            ),
            FixEvent(
                id = 38,
                icon = "https://ya.ru/images/search?cbir_id=1030127%2FXX-XP__jWg71DdsD82BnZA329&cbir_page=similar&crop=0.016%3B0.016%3B0.984%3B0.984&img_url=https%3A%2F%2Fstatic.ngs.ru%2Fnews%2F99%2Fpreview%2F2c81a1e4b696c665e3f6e03d7ea5113d03c8ea71_9999.jpg&lr=21639&pos=0&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F1030127%2FXX-XP__jWg71DdsD82BnZA329%2Forig",
                title = "Developer Meetings",
                date = "13.09.2024",
                city = "Москва",
                tagDevelopmentLanguage = "Kotlin",
                tagGradeDeveloper = "Junior",
                tagCityMeeting = "Moscow",
            ),
        )

    val mockCommunityDetails =
        CommunityDetails(
            1,
            "Designa",
            "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\n" +
                "Volutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh molestie faucibus sit mi risus eget. Vivamus dolor ac tortor nibh. Metus amet odio id magna. Augue ac commodo sem varius purus eros eu pharetra nec.\n" +
                "Bibendum eget donec senectus turpis massa. Magna nunc diam pellentesque egestas sit auctor. Ullamcorper placerat blandit eget scelerisque adipiscing nisi tellus. Aliquam aliquet arcu diam cursus. Egestas duis tellus etiam molestie imperdiet. Tellus turpis purus ligula odio at facilisi. Felis sed in adipiscing ut et amet eros at. Tortor tempor habitasse molestie sed enim condimentum. Purus tellus nec lacus nisl eu sit venenatis elit. Nunc at lacus sit iaculis et volutpat. Elit id vulputate non sed placerat neque parturient egestas. Proin pellentesque bibendum volutpat adipiscing sagittis habitant elit.\n" +
                "Odio justo dignissim ullamcorper purus ullamcorper sit semper dictum. Tortor est mauris aliquet amet sit ultrices auctor nulla. Faucibus aliquam etiam pharetra pellentesque sagittis odio lacus. Eu morbi senectus in massa fermentum elit in. Tincidunt est blandit malesuada auctor. Orci tellus mus aliquam accumsan ac. Et urna nisl facilisis non volutpat et sodales.\n" +
                "Malesuada egestas enim purus cras diam eget vel. Massa ante sit scelerisque scelerisque hac. Consequat tempor non pretium convallis. Interdum iaculis sit interdum interdum magna. Gravida urna et cursus donec consectetur nulla. Aliquet egestas nulla arcu aliquam facilisi duis maecenas viverra. Egestas consectetur mauris orci sit. Bibendum orci at viverra pharetra tortor nulla amet erat vehicula. Mauris volutpat amet in sit rhoncus. Imperdiet feugiat id fames gravida.".trimIndent(),
            mockMeetingsData,
        )
}
