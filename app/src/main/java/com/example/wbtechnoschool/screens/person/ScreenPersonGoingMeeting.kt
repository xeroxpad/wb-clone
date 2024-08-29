package com.example.wbtechnoschool.screens.person

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.domain.entities.FixPerson
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.utils.avatar.FixMyAvatar
import com.example.wbtechnoschool.utils.tags.FixTags

@Composable
fun ScreenPersonGoingMeeting(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val users = listOf(
        FixPerson(
            id = 1,
            name = "Анастасия",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/c6dc/9a5b/9cc40897f19e46b907399c8755e1f9ea?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=KXY33iKlvcs2fRDt7z2ymePeIpxUOpvcJRd4xoeeIY6mOlF~dv9u7memTOnKDqPd-YXFo77Wc8~IhmaL1wWdzscyHSOYIpDsvZwxdN5CGZC5zQrjlefxAU6sQ54sFnxsCdpO-rwCCqzn2mNc-nUcksbZpmTKmwPacnwjwZIoXXjGvtI~fmUYSMiyGH7NtTon0KePWgf~Z~yIIQAqPGA5tfqltU7yx4o5aFh5b9PLnUddsnl-JG2Whah9B7~mUcyL3Fcy~q49IzZRNUJT3fq4KI91Ii0LxDrohLeS7quDtjmES-wc0Br2fl5tsY9sdEBiJNY3o7HRx1RQwUPAiRZp6w__",
            interests = "Дизайн",
        ),
        FixPerson(
            id = 2,
            name = "Артём",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/cd1c/ae55/2d892c53aaf550d83b2065d95fc3e359?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=d3q93Y4qVORFhqvWN4IphuEVpijylqNLQhRPb0gB4P64nq8LFmR8Ll61H6M5fvK5LuELJUfQtq6HJqsb6dvi-O3cw4XG2vumQCvjuXBHg2l4A0a3mjCSJ~Han9DIhfYl0iuuEG2B4gWDIbbZOHZEifih0u2DncADRmuLHnXITAPISzqt6ikD8oaJJh5BR3FBsNS1lOaYbASYf7UN0gLFSakPhxFGAABSTP0N2WKkzZ78481w0hkOVP-QFqvrFsMDGasmu1SJGjh3XLVCXf~VrrB~Ay5W~holk~FhyXlgq5DTyEHsPfi2Y5RMgxpwe9sj-Of2psCtUZRPOSVhV5Zfhg__",
            interests = "Бизнес",
        ),
        FixPerson(
            id = 3,
            name = "Ирина",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/036a/cce4/1c2c712fd0bb1df50d68ca1ded6e8dfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=DW1MvnYNx5RVWnxsSjP9UiYgCcGx2JaKB2MmoC6j6NE4kUa2VxFyMbyw~UAQGQsBFqPndroGyUwuaVTnCQB35~dG-cLjw6MBlofznPQgmDpeH7C6hxcoaPXNXkbY~7cXVY7okdyATPWy3XEuUBSRNV7qe8mKG0UDy7c2oDo4mMNHxwX35d8MXLEpmqv~ndjiEztEonb~QyVX0Lwx-MEpnNP3fcFYwug4jMtW5DgCZL438ij94IXSvEqJPmr8IsJxQyettV5Ik04dOqONaB~npG4qYCC~-yKCK74LvV2~tMRO5BukiIMgIx3viVQ3loShuInG17ZVcpZp7sNsJSQPgQ__",
            interests = "Разработка",
        ),
        FixPerson(
            id = 4,
            name = "Алина",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/5989/ea00/c1e221d9161c5693219ccdac673256ca?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=HfZSMihLIZ07n6Pe5MIDmii-2fUMQlPH7SL~65rphx0sCT1kZ9psOcpYkuheO1je-yV515hzqWxFLAryjLUHoRLCCWD~zjMQonZc4W82tL3Qoyy0WpjiBVq4GfHqGN4ldv8TyyZu8JffrdqRAYSTCre-PG1lcSQokY1RZYumiVbIe2gT6Ju9AJNQLie6X8lL9G8Lj3OZCxCmNO5z-wfflnTRCy0jzFn2VYvf1XStCh3V5sb7f34rIw6gUlaI0QfCX5Qex4nOvLqLWvX-LKMuH-vhJ~XFrTXhUCGZnuqcnwnLcNxDU9uv2GGOwpQsYa~7jaKA2EPTXttqhN1~e~sO9g__",
            interests = "Разработка",
        ),
        FixPerson(
            id = 5,
            name = "Никита",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/362a/c0bf/6cdf56b54cb8015b928a15af9fdae43e?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=A81DOdlwiQ1Q3mx37ltMnCwQ-CS5YsElhXtE4tvUV4K94zpKSGV4b0-11nAzU-uygXcl1YLHOwFESC7hRr2FlI7bjxKeVxu6gLt~Gk8pSgYX3sg1fza5AChVLjcs6zBPUDK5PWDzgVTL5YcJmIC67ML2Uti6ZR~gz1DZv-dUK6pG4E-Kal8ip4n4lGPf73s48vOUsEUycaydB4NNYERQG0StuBcsOgz2oLt2mj0OcJ~eI4qCfZXZ31PxiT8esCVakAYjM8SDbkY4v3XOgMWADwCgIotCuUgmalOQ1Or8eK7k-9EHWak8BTxi4Vk4hmidVWz97nFbpxKjP-GLYxVivA__",
            interests = "Продакт",
        ),
        FixPerson(
            id = 6,
            name = "Яков",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/3aec/d88a/2b019e2d5f183a3a8e41d0333fa04d81?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=EcdJksE5xbzKVRyv4lT1DYfryya-~WAVmI0mzmdn~oFTMJVDtYNUJT6QX5d00~ZAgvkswrx0WGLNHkzVZAmRcZYXcpB17z~UKioJXVstQTRqYb4UP0eZaqnJX4XYMSX4qFTK~97MEwgyMEghyuut0BZrox9cd7i2j4Af8bb2LhrMQOCNCh7PirSXZs~UE~D4GMCKVAdxHf4uRB9lLtCWqKN-AMBhfmuhHNBx1Xr7T~r0Dab3QgZdl8ukq08D8I7S-JQYbJLS0IaD60eo-5OuXub0i3SKo3I1dZNSATledYY0CzYYdrZbajAUWOuidfUHc40FaEov46BDZ3AF6~xWZw__",
            interests = "Разработка",
        ),
        FixPerson(
            id = 7,
            name = "Ексей",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/d79b/7dcc/2497712e1509ef63befbd9e5d5b00db3?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=d-0HU7dVnN7BvJZbIim9DdeA9xVdQpCmS7qOqlb6u8YyIlrn-05lJgEFiHC2dACN6Sairf0NQ-GU8FZhlIKYV5Bv6DjfJVB2HUI1bHl01D7156sdNOqhZPCfDlUXx5tofvtpDB2x0W0XXGQXb6uQQ6KxVSBGx8ZcIKiUHnuBtoROhnFrECfY1Kz8Y7MMsV54cEbLtLy4Zd61-W5Xz330QWm-llSiResb93Zngua5G~TFVlG4sQx~2EKvSpT3gQ2yuZV3VJED3vCAZ1xra-mHavlx8uCh7YV6C804HgjNtDRfLpHOrgtb9cslin0FyJt11C4ES-2-iZ7DlBD4PuPypg__",
            interests = "Разработка",
        ),
        FixPerson(
            id = 8,
            name = "Андрей",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/6664/62a2/57cc6d978a8e930f4518f34c17b7644f?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=XFL8Q-GSCGhm-w3Cntxdv1UHF~CF0K~JpCwyk1gO4~6xDdCBedePLz75R8ypx-xHjh8tMfncr7VynVIQVGesv6BF5FLiS9C9uDXQ9yh~YbBOQxqoIQIg2iJ7Q7DFuEPXRVnDjo4neGM56V7RXDaxBkoWHF7Kttd~7~KLvTGfo2V1kadpN7vkiXgE19h3YT38XDPgQGs-soeKmN-suZ5laF7ffmAb2hzh-ZF9sV8XLNMuuhHUiKl0Kplgav-Vz~xqgsGF-AhfUzpn4-Br82shkL2cebg2Uad-CUbAGpHoCkIZiP66aGYzoJci9IXUxUs1wcR1PmAAhQUSlYwhEGp6Gw__",
            interests = "Девопс",
        ),
        FixPerson(
            id = 9,
            name = "Мария",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/5852/7d7b/f82a74a9210c057ffb5500e61c1a2061?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=UBfGnY86s~UjExQF~E6vySWcQ5bH7Qv2FMrU93vs0dfkLfw9nSYGrJL1S6JlLqij7QU2ZtOYfggNNrqwYt6TvR3I1TXnqUE5lMCGkGbMPl4Fle7wxnJblFiMy3ngD~361muuo0yQJwyd43uryM9J3DtkJdozxN7VukOBFQowthu6HK8WMzWo~cNt7jJYNxhjaPORNUksWM67w0uVAHrzkEqOxolO0aJqBf83C6pgGzirmNOgqKWyCd2D9~XaJIhUM3AA9Rw0QXdjHHDpTB0uWsofdNvXr44rePpjw8uRdBNSvAwyBiBsi~Rt9156VpenNi26YDfrLe2Ph519Y9gz0A__",
            interests = "Тестировка",
        ),
        FixPerson(
            id = 10,
            name = "Александр",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/4a84/5837/b241932d60b5fc99ce22466e8e6c5066?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=fMZAjbCf64p1iROTW2DI9a6bYCIBpxoF59sDKfp-BZEZj~JlHVz4stcm6AMsZobXuoQ0XhuFBTd~1lUBRUlRFijRq-9ir0w44mvwjcoOGV01zc-1Tj1N4xGAwm~zRRONLYaOzQpZTNbqDNsATbl3k5Cm8rEzPiOrnF8WvB8cAERvp2nd29YlWbsyVrSTNh8kONuwZVv7G0Pwpv0~t44G-8lU1SevTEONy9CiOuKmOFW8eJ7jRYgWfpTDFeNypr4tm0EewGq~SgtcktUgV9IGtc5JqUW58~fzsgHVeRl-~yYQvIhNMlAIFXaSRFpuCQmUtD9CXJV09MHCBigSXP3rfQ__",
            interests = "Разработка",
        ),
        FixPerson(
            id = 11,
            name = "Регина",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/afe0/5fef/e93bd1a92de59c6f160a6c6236f0524d?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=VtM2XmiHZreeZpYTq6zrHm9X7Vt4evGA99Es2vyuO3oFgIcQCjMTGn~e9FH-eGnSVrF9ySK1NrVoeftfx8a9BexmJ-0oMWwxH1OjpqaoJh0Bd1gRZP3XrtwY-aFxh9Tw4V1R36yHzar5EPjog~aiVWSyDSonsgauF6~LetwDaUPGBzVvdMM0SGNp4JwlyykC~wQxSBcF-cAkF1ZdC5Vq7gcgLV-tc7qnwBlzICYRjO-8zfleWja5o38Zpue-BjuXvLLP8BO88kV5piXzHwcimFv41ZLnVgm25r2vO2epJ6sdjbKSnfQOcXyd1~CsKMz4XPtUu-sGOsAcfkFwaqQWqg__",
            interests = "Разработка",
        ),
        FixPerson(
            id = 12,
            name = "Сабрина",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/1570/23cf/da882a73cfbf3cf8109ab256d74b8ef0?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=hwoUBcZEQgqc6I9ZIiPLL8osto9ELeoAGR-GfCS~j6Z2JM0zdDjlf4YSfzP5wc8KGW3X9Z~G2CmHBxi9L5KfWlCvlIj1cT0alDlecYeVQY8Mb1HQAdcteqKtCxikd5-shTk0RRmJ0qYRSNgJeYenlP69kIdwrYWDGImikdP6Y6Jwrmzwu1pEokPCBdy8v-msSk3az1eWTND48757AnEYpBfjkFanLf~a7CmiJC-AHGkf-GGD7pTIdb9H-t0N6kieXOvgKNAltM1tfysb~C2w0nOvB1-zYmrU2eV3EDxcn75PutO~u8mqysl6SQBuNvvips~NAs95eERDIewPx6G9uA__",
            interests = "Проджект",
        ),
        FixPerson(
            id = 13,
            name = "Юлия",
            avatarUrl = "https://s3-alpha-sig.figma.com/img/6ab9/8f92/4f70002fd4942cabcbe9671410ea4cf0?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=StaLWNL~EYVYP9GhORr2UV~cUH3h8-3ERXKZUjGoBLlrVwMtwIpC~IPRm1vF-G75-LpJDobxbCFo3LUmgrU78aIu8ECa62e8xeAr4PbuwpfKTm5GVDV62WbN-xy1Spllz2oKjlyFtex9NTsYFXxYJOb-8ytgpmcLoldbufK1zSv7-JncGNUByyLalhXVrcijQZvgSY5cnA9INKCe3Smv6FzbDRlD14iFlol8DQ4JJHsBMyXxiKBchPgQCOU8g8~DX1s9W43ifQE7O86m9lCevVJ9itJBidpzUYy84dIjclYz3O5w900zphoHOh4buREh99zVT5r9XgeeF1GbknY1lg__",
            interests = "Продакт",
        ),
    )
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = "Пойдут на встречу",
                iconBack = { navController.popBackStack() },
                iconShare = null
            )
        },
        content = { paddingValues ->
            Spacer(modifier = Modifier.height(20.dp))
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(paddingValues),
                columns = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(users.size) { index ->
                    val user = users[index]
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(16.dp))
                            .width(104.dp)
                            .clickable { }
                            .padding(5.dp)
                    ) {
                        FixMyAvatar(
                            model = user.avatarUrl
                                ?: "https://sneg.top/uploads/posts/2023-06/thumbs/1688043519_sneg-top-p-avatarka-fotoshop-vkontakte-21.jpg",
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .fillMaxSize()
                        )
                        Text(
                            text = user.name,
                            fontWeight = FontWeight.W500,
                            fontSize = 18.sp,
                            color = Color.Black,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                        FixTags(
                            labelText = user.interests,
                        )
                    }
                }
            }
        }
    )
}