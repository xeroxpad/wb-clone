package com.example.data.repository

import com.example.domain.entities.Community
import com.example.domain.entities.CommunityDetails
import com.example.domain.entities.FixEvent
import com.example.domain.entities.Meetings
import com.example.domain.repository.ICommunityRepository

class CommunityRepositoryImpl : ICommunityRepository {
    override fun getAllCommunity(): List<Community> = mockCommunityData

    override fun getDetailsCommunity(): CommunityDetails = mockCommunityDetails

//    val mockCommunityData =
//        listOf<Community>(
//            Community(
//                id = 0,
//                icon = null,
//                title = "Яндекс",
//                countPersons = null,
//            ),
//            Community(
//                id = 1,
//                icon = "https://weldtex.ru/wp-content/uploads/2024/01/ozon.png",
//                title = "Озон",
//                countPersons = "1 000 человек",
//            ),
//            Community(
//                id = 2,
//                icon = "https://avoshop.ru/upload/iblock/a8a/9gldo5wx1d1xngaj5m71b2c77ybz5tku.png",
//                title = "Wildberries",
//                countPersons = "100 000 человек",
//            ),
//            Community(
//                id = 3,
//                icon = "https://oscomp.ru/upload/iblock/b53/lmuwr5qb16y6bwiezy24zgty95zaf1ud.png",
//                title = "Huawei",
//                countPersons = "50 000 человек",
//            ),
//            Community(
//                id = 4,
//                icon = "https://u.9111s.ru/uploads/202206/09/c5e55d54ff5036ff6b09a378bad27c21.png",
//                title = "Apple",
//                countPersons = "5 000 человек",
//            ),
//            Community(
//                id = 5,
//                icon = "https://tehnomir71.ru/upload/iblock/c11/c113e3db6aa18e7cd34b5433b457deb0.jpg",
//                title = "Samsung",
//                countPersons = "3 000 человек",
//            ),
//            Community(
//                id = 6,
//                icon = "https://strogino.mos.ru/upload/medialibrary/005/cn52sgfb49fyxdslyf98hqx7lff63fbs/800px_Vk_logo.svg.png",
//                title = "VK",
//                countPersons = "1 000 человек",
//            ),
//            Community(
//                id = 7,
//                icon = "https://retrobloha.ru/naborspichek20let/images/g0ea0GZ5LXR_h1NrOrBGDWOQ0oQ=/1199x/ff0b8095-4519-49f1-af84-035d53966dea.png",
//                title = "Avito",
//                countPersons = "100 человек",
//            ),
//            Community(
//                id = 8,
//                icon = "https://pochemu-ne-rabotaet.ru/wp-content/uploads/2022/09/ламода.jpg",
//                title = "Lamoda",
//                countPersons = "20 000 человек",
//            ),
//            Community(
//                id = 9,
//                icon = "https://geekville.ru/wp-content/uploads/2023/08/1-43.jpg",
//                title = "МТС",
//                countPersons = "2 000 человек",
//            ),
//            Community(
//                id = 10,
//                icon = "https://rendercar.ru/wp-content/uploads/2023/03/tinkoff-logo.png",
//                title = "Тинькофф",
//                countPersons = "5 000 человек",
//            ),
//        )

    val mockCommunityData =
        listOf<Community>(
            Community(
                id = 0,
                icon = "https://s3-alpha-sig.figma.com/img/4444/d138/f8b1f7772ef6d067ca0e48c2eadc47df?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=afvBgFdd-0ppE22SQS02gjuabkdEhJpmOJB3omwBcDfiRX7VxhyQWasVGpr3h5-Qxx35fngtmYJwYrzNsmmagpXL6OqMe9U0vN~~TZTAMSiNCCWZDIjoafMB6g8G1Sm2lEYBJ1Lzdf1Bd6uD4BY0qyBrMYcteLYB0B9MT3azMGAqUNbR7feAgvPfm5ywn0BtBhD10BHsnZBhLswXm2IpM0H0ra~V0~DXXu7AXwwPZ2jp5eHRwzk1gFNCS4s3ZQnECOSjtmdVaZ-9gxKKM0Mg96Eou3Nyz0T8-w1aVRcCPFH5t5qAy2ziV-DGUEEy6b42dGjyfsNWDp3SfKmd9-p9xg__",
                title = "Супер тестировщики",
            ),
            Community(
                id = 1,
                icon = "https://s3-alpha-sig.figma.com/img/c9a7/54d7/03ba23f3bfdf6a1d3847f7b696a6eedd?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=GPklw6vp2sk5cLXDWVnekLI3NCSHfhK9OXi0eINfUoNrzCVDvPpGe~ns8M4OTi2stt-0106ocpNKqa0vuXUPOSSum97k58KX7wsAuuJOhP0eWo3l3xuhr4ZirrvZzOYEzOFQSTWIte0U-lW-pHp7ayuIQqvdnkixUAw4e~TzZ-GpK6~vOnI1vu8KVDoL72FTeZqpuwNtON-w7Cxt80GXrGX7PsQw0zUffFC-WaePD9sOMt4oxmubUmU7Gywh-rwddqhlxzG-7W4nQ6OtMOBGz8TaJIPGQypqkEuLjMzIDYp6Nh~ZV37wr79J4T92nnLCN8XP9t-jFEsevIkWWbdBUA__",
                title = "Разраб",
            ),
            Community(
                id = 2,
                icon = "https://s3-alpha-sig.figma.com/img/773b/0378/e162f6022e3a3c37d762206749a88ee4?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=o5iF5-dRvLn7psVphiMKkpo4Ky4hzF9HNI~0d4adMIrOcoa5EFnbcKbN8svopXgQnkn-7wF5AqnjNRFOVAUb4dM7euTCbgZb6wyhX5-RO1BaNGUyjZ1-w-Uj7Pb5SivVJLEe~cY69SZaKkE-ALnqpH5Jj2eGKGnKWt0iMcRTNxFeyXKhBUTSJeww7vmqTUhHPwNWeP83eOn7dYgNLUQjYL6DH1BnnYnLJLgojW4rjQ3TmfatQ7fHr-j6PSGXj0z3fLeCzRtIilgXB6MsTYnShtPF33iHL6BIxBHjaY5f~hfssBnkT-G8cToZ4FFgaDp~JYAyIKYBfrlmMaLGrjh8iQ__",
                title = "Хабр",
            ),
            Community(
                id = 3,
                icon = "https://s3-alpha-sig.figma.com/img/f32e/7373/028b1a961e2e3dcde2f9ea3584eab541?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=KOPRBeUslTm7Hclvxtn07TllKccGTFKtIufh2fYMbbrQgYqejLE6MJj6~n8xsKXhf4yd8kFrFudwbjOwt6HWCsrg7nx4zBbfVVQYkylOmiCKzqHF5klW5NcZGSb3PPi4pvYrThnRVajCE07jlFwCRgTf72sVpQzQTrs6fIJqxPrJd2aiK06jKQQQhKHVqmYI~d57xYu1b3K-SfoazxwKw0vHDHS0SpGmoEzRg2A-45RZmkzvmreQwPOSLZRLMoIe51GE208jbTdtr4OqwVMssnOdyt04Xf35VEB-v2fKYKl2G6eKh1WbX27fD43EkQvINXPM4qEsUSQCdtKNOCidjQ__",
                title = "Запускаем гуся, работяги",
            ),
            Community(
                id = 4,
                icon = "https://s3-alpha-sig.figma.com/img/4444/d138/f8b1f7772ef6d067ca0e48c2eadc47df?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=afvBgFdd-0ppE22SQS02gjuabkdEhJpmOJB3omwBcDfiRX7VxhyQWasVGpr3h5-Qxx35fngtmYJwYrzNsmmagpXL6OqMe9U0vN~~TZTAMSiNCCWZDIjoafMB6g8G1Sm2lEYBJ1Lzdf1Bd6uD4BY0qyBrMYcteLYB0B9MT3azMGAqUNbR7feAgvPfm5ywn0BtBhD10BHsnZBhLswXm2IpM0H0ra~V0~DXXu7AXwwPZ2jp5eHRwzk1gFNCS4s3ZQnECOSjtmdVaZ-9gxKKM0Mg96Eou3Nyz0T8-w1aVRcCPFH5t5qAy2ziV-DGUEEy6b42dGjyfsNWDp3SfKmd9-p9xg__",
                title = "Apple",
            ),
            Community(
                id = 5,
                icon = "https://s3-alpha-sig.figma.com/img/773b/0378/e162f6022e3a3c37d762206749a88ee4?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=o5iF5-dRvLn7psVphiMKkpo4Ky4hzF9HNI~0d4adMIrOcoa5EFnbcKbN8svopXgQnkn-7wF5AqnjNRFOVAUb4dM7euTCbgZb6wyhX5-RO1BaNGUyjZ1-w-Uj7Pb5SivVJLEe~cY69SZaKkE-ALnqpH5Jj2eGKGnKWt0iMcRTNxFeyXKhBUTSJeww7vmqTUhHPwNWeP83eOn7dYgNLUQjYL6DH1BnnYnLJLgojW4rjQ3TmfatQ7fHr-j6PSGXj0z3fLeCzRtIilgXB6MsTYnShtPF33iHL6BIxBHjaY5f~hfssBnkT-G8cToZ4FFgaDp~JYAyIKYBfrlmMaLGrjh8iQ__",
                title = "Samsung",
            ),
            Community(
                id = 6,
                icon = "https://s3-alpha-sig.figma.com/img/773b/0378/e162f6022e3a3c37d762206749a88ee4?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=o5iF5-dRvLn7psVphiMKkpo4Ky4hzF9HNI~0d4adMIrOcoa5EFnbcKbN8svopXgQnkn-7wF5AqnjNRFOVAUb4dM7euTCbgZb6wyhX5-RO1BaNGUyjZ1-w-Uj7Pb5SivVJLEe~cY69SZaKkE-ALnqpH5Jj2eGKGnKWt0iMcRTNxFeyXKhBUTSJeww7vmqTUhHPwNWeP83eOn7dYgNLUQjYL6DH1BnnYnLJLgojW4rjQ3TmfatQ7fHr-j6PSGXj0z3fLeCzRtIilgXB6MsTYnShtPF33iHL6BIxBHjaY5f~hfssBnkT-G8cToZ4FFgaDp~JYAyIKYBfrlmMaLGrjh8iQ__",
                title = "VK",
            ),
            Community(
                id = 7,
                icon = "https://s3-alpha-sig.figma.com/img/4444/d138/f8b1f7772ef6d067ca0e48c2eadc47df?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=afvBgFdd-0ppE22SQS02gjuabkdEhJpmOJB3omwBcDfiRX7VxhyQWasVGpr3h5-Qxx35fngtmYJwYrzNsmmagpXL6OqMe9U0vN~~TZTAMSiNCCWZDIjoafMB6g8G1Sm2lEYBJ1Lzdf1Bd6uD4BY0qyBrMYcteLYB0B9MT3azMGAqUNbR7feAgvPfm5ywn0BtBhD10BHsnZBhLswXm2IpM0H0ra~V0~DXXu7AXwwPZ2jp5eHRwzk1gFNCS4s3ZQnECOSjtmdVaZ-9gxKKM0Mg96Eou3Nyz0T8-w1aVRcCPFH5t5qAy2ziV-DGUEEy6b42dGjyfsNWDp3SfKmd9-p9xg__",
                title = "Avito",
            ),
            Community(
                id = 8,
                icon = "https://s3-alpha-sig.figma.com/img/773b/0378/e162f6022e3a3c37d762206749a88ee4?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=o5iF5-dRvLn7psVphiMKkpo4Ky4hzF9HNI~0d4adMIrOcoa5EFnbcKbN8svopXgQnkn-7wF5AqnjNRFOVAUb4dM7euTCbgZb6wyhX5-RO1BaNGUyjZ1-w-Uj7Pb5SivVJLEe~cY69SZaKkE-ALnqpH5Jj2eGKGnKWt0iMcRTNxFeyXKhBUTSJeww7vmqTUhHPwNWeP83eOn7dYgNLUQjYL6DH1BnnYnLJLgojW4rjQ3TmfatQ7fHr-j6PSGXj0z3fLeCzRtIilgXB6MsTYnShtPF33iHL6BIxBHjaY5f~hfssBnkT-G8cToZ4FFgaDp~JYAyIKYBfrlmMaLGrjh8iQ__",
                title = "Lamoda",
            ),
            Community(
                id = 9,
                icon = "https://s3-alpha-sig.figma.com/img/4444/d138/f8b1f7772ef6d067ca0e48c2eadc47df?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=afvBgFdd-0ppE22SQS02gjuabkdEhJpmOJB3omwBcDfiRX7VxhyQWasVGpr3h5-Qxx35fngtmYJwYrzNsmmagpXL6OqMe9U0vN~~TZTAMSiNCCWZDIjoafMB6g8G1Sm2lEYBJ1Lzdf1Bd6uD4BY0qyBrMYcteLYB0B9MT3azMGAqUNbR7feAgvPfm5ywn0BtBhD10BHsnZBhLswXm2IpM0H0ra~V0~DXXu7AXwwPZ2jp5eHRwzk1gFNCS4s3ZQnECOSjtmdVaZ-9gxKKM0Mg96Eou3Nyz0T8-w1aVRcCPFH5t5qAy2ziV-DGUEEy6b42dGjyfsNWDp3SfKmd9-p9xg__",
                title = "МТС",
            ),
            Community(
                id = 10,
                icon = "https://s3-alpha-sig.figma.com/img/773b/0378/e162f6022e3a3c37d762206749a88ee4?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=o5iF5-dRvLn7psVphiMKkpo4Ky4hzF9HNI~0d4adMIrOcoa5EFnbcKbN8svopXgQnkn-7wF5AqnjNRFOVAUb4dM7euTCbgZb6wyhX5-RO1BaNGUyjZ1-w-Uj7Pb5SivVJLEe~cY69SZaKkE-ALnqpH5Jj2eGKGnKWt0iMcRTNxFeyXKhBUTSJeww7vmqTUhHPwNWeP83eOn7dYgNLUQjYL6DH1BnnYnLJLgojW4rjQ3TmfatQ7fHr-j6PSGXj0z3fLeCzRtIilgXB6MsTYnShtPF33iHL6BIxBHjaY5f~hfssBnkT-G8cToZ4FFgaDp~JYAyIKYBfrlmMaLGrjh8iQ__",
                title = "Тинькофф",
            ),
        )

    val mockMeetingsData =
        listOf(
            FixEvent(
                id = 31,
                icon = "https://s3-alpha-sig.figma.com/img/9e0b/4653/93a4987dcdd3d4a37afdd74a85ee4518?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=aA8JbMQaG4VDlQ53SC~4kmAhbCSLyDsJ~tFzu9rv5ecxZLo4W7ke47thxwMFFooJz80g5CgwTw9KdRNgtPT4DFaNUHbiELf5tj3yuDpMkCG-qL7gRF2hHiA9oSyo2qeBiBVZ0cqosd36JnZRHX0UoqeUiXCkX9dqI74Hxs~JL~SXxPqTUKZpusBXUOvBacBhLnhyyia5h11Qd86gRsIZ7Vdb5H4mUIIqlY96lhxTh-CNRSSLC4N3RI82kzxMqvOmdUGatANqAgKQD-zBqtGxEoapHu6Vm5Us-d1Rg~MkldjTvWOnoKDGwFojZJMOn2YTw0ist8hYDJ4A48CsApuzMQ__",
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
