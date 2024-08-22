package com.example.wbtechnoschool.screens.meetings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.avatar.FixMyPreviewAvatar
import com.example.wbtechnoschool.utils.avatar.FixRowAvatars
import com.example.wbtechnoschool.utils.avatar.RowAvatars
import com.example.wbtechnoschool.utils.tags.FilterChips
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER
import com.example.wbtechnoschool.utils.events.FixCardMeetingMini
import com.example.wbtechnoschool.utils.tags.FixFilterTags
import com.example.wbtechnoschool.utils.tags.FixTags
import com.example.wbtechnoschool.utils.widgets.ShowImage
import com.example.wbtechnoschool.utils.widgets.ToggleButton
import com.example.wbtechnoschool.viewmodel.meetings_view_model.DescriptionMeetingViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import org.koin.androidx.compose.koinViewModel

//@Composable
//fun ScreenDescriptionMeeting(
//    navController: NavController,
//    modifier: Modifier = Modifier,
//    viewModel: DescriptionMeetingViewModel = koinViewModel()
//) {
//    val showMoreText by viewModel.showMoreText.collectAsState()
//    val isGoing by viewModel.isGoing.collectAsState()
//    val meetingDescription by viewModel.meetingDescription.collectAsState()
//    Scaffold(
//        modifier =
//        modifier
//            .statusBarsPadding()
//            .fillMaxSize(),
//        topBar = {
//            MainTopAppBar(
//                title = stringResource(id = R.string.top_bar_description_meeting),
//                iconBack = { navController.popBackStack() },
//                actions = {},
//                actionsIcon = R.drawable.icon_bird.takeIf { !isGoing },
//                actionsTint = LightColorTheme.brandColorDefault
//            )
//        },
//        content = { innerPadding ->
//            Column(
//                modifier =
//                Modifier
//                    .fillMaxSize()
//                    .navigationBarsPadding()
//                    .padding(innerPadding)
//                    .padding(
//                        start = MagicNumbers.SCREEN_DESCRIPTION_MEETING_CONTENT_COLUMN_PADDING_START.dp,
//                        end = MagicNumbers.SCREEN_DESCRIPTION_MEETING_CONTENT_COLUMN_PADDING_END.dp,
//                        bottom = MagicNumbers.SCREEN_DESCRIPTION_MEETING_CONTENT_COLUMN_PADDING_BOTTOM.dp
//                    )
//            ) {
//                LazyColumn(
//                    modifier =
//                    Modifier
//                        .weight(1f)
//                        .clickable(
//                            interactionSource = remember { MutableInteractionSource() },
//                            indication = null
//                        ) { viewModel.toggleShowMoreText() },
//                    verticalArrangement = Arrangement.Top
//                ) {
//                    item {
//                        meetingDescription?.let { description ->
//                            Row(
//                                modifier =
//                                Modifier
//                                    .padding(top = MagicNumbers.SCREEN_DESCRIPTION_ROW_PADDING_TOP.dp)
//                            ) {
//                                Text(
//                                    text = description.dateAndLocation,
//                                    fontFamily = fontSFPro,
//                                    fontWeight = FontWeight.W600,
//                                    fontSize = MagicNumbers.SCREEN_DESCRIPTION_ROW_TEXT_FONT_SIZE.sp,
//                                    color = LightColorTheme.neutralWeak
//                                )
//                            }
//                            Row {
//                                description.tags.forEach { tag ->
//                                    FilterChips(labelText = tag)
//                                }
//                            }
//                            Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
//                            ShowImage(model = R.drawable.map)
//                            Spacer(modifier = Modifier.height(SPACER.SPACER_15.value.dp))
//                            when {
//                                showMoreText -> {
//                                    Text(
//                                        text = description.description,
//                                        fontSize = MagicNumbers.SCREEN_DESCRIPTION_SHOW_MORE_TEXT_FONT_SIZE.sp,
//                                        fontFamily = fontSFPro,
//                                        fontWeight = FontWeight.W400,
//                                        color = LightColorTheme.neutralWeak
//                                    )
//                                }
//                                else -> {
//                                    Text(
//                                        text = description.description,
//                                        fontSize = MagicNumbers.SCREEN_DESCRIPTION_SHOW_MORE_TEXT_FONT_SIZE.sp,
//                                        fontFamily = fontSFPro,
//                                        fontWeight = FontWeight.W400,
//                                        color = LightColorTheme.neutralWeak,
//                                        maxLines = MagicNumbers.SCREEN_DESCRIPTION_SHOW_MORE_MAX_LINES,
//                                        overflow = TextOverflow.Ellipsis
//                                    )
//                                }
//                            }
//                            Spacer(modifier = Modifier.height(SPACER.SPACER_15.value.dp))
//                            RowAvatars(arrayImage = description.rowAvatars)
//                        }
//                    }
//                }
//                ToggleButton(
//                    isSelected = { _ ->
//                        viewModel.toggleIsGoing()
//                    },
//                    modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .height(MagicNumbers.SCREEN_DESCRIPTION_TOGGLE_BUTTON_HEIGHT.dp)
//                )
//            }
//        }
//    )
//}

@Composable
fun ScreenDescriptionMeeting(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: DescriptionMeetingViewModel = koinViewModel(),
    viewModelMeeting: MeetingViewModel = koinViewModel()
) {
    val meetingDescription by viewModel.meetingDescription.collectAsState()
    val events by viewModelMeeting.meetings.collectAsState()
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = "Как повышать грейд. Лекция Павла Хорикова",
                iconBack = { navController.popBackStack() },
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier =
                Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { viewModel.toggleShowMoreText() },
                verticalArrangement = Arrangement.Top
            ) {
                item {
                    meetingDescription?.let { description ->
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        ShowImage(model = "https://s3-alpha-sig.figma.com/img/5310/9837/d03623c9359404e018318e330b337649?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Ya6vjqtdEqpI~GN310Bcg2yuC-vMqHnW8mS1qc6G2YFsS6TJXUEIPAwTWbnBrTdfUcX9oOs9ybn-THCDN3kLYOJDKumiCwgkUQxqJ09mZv9PxHzgt-uFJa1MPYECRtiY9KaalImG-Lvr~dhDd4rOMmOnH3EpZVthXSvgdPGLxkQqPpvRpgYlSIbT9yAY-k7AGE6oUQc64Ptv~lNdZKjAaEccBMGuf4KMIoioYCaQwSY~4DBrhUYi1lA65JaafpGEmxLQh87PqSKNs9HEAd0hFelefm4QFhiHJ1181~2gutY74RzmSyWC3b42HOWN309d5zj64RBB5CYYKJQtCK1vCQ__")
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        Text(
                            text = "Как повышать грейд. Лекция Павла Хорикова",
                            fontFamily = fontSFPro,
                            fontWeight = FontWeight.W700,
                            fontSize = 34.sp,
                            color = LightColorTheme.black,
                            lineHeight = 30.sp
                        )
                        Row {
                            Text(
                                text = description.dateAndLocation,
                                fontFamily = fontSFPro,
                                fontWeight = FontWeight.W600,
                                fontSize = MagicNumbers.SCREEN_DESCRIPTION_ROW_TEXT_FONT_SIZE.sp,
                                color = LightColorTheme.neutralWeak
                            )
                        }
                        Row {
                            description.tags.forEach { tag ->
                                FixFilterTags(
                                    labelText = tag,
                                    isSelected = false,
                                    onSelectionChanged = {},
                                    modifier = Modifier.padding(end = 10.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        Text(
                            text = description.description,
                            fontSize = MagicNumbers.SCREEN_DESCRIPTION_SHOW_MORE_TEXT_FONT_SIZE.sp,
                            fontFamily = fontSFPro,
                            fontWeight = FontWeight.W500,
                            color = LightColorTheme.black,
                            lineHeight = 17.sp
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        Text(
                            text = "Ведущий",
                            fontWeight = FontWeight.W600,
                            fontSize = 24.sp,
                            color = LightColorTheme.black
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.weight(2f)) {
                                Text(
                                    text = "Павел Хориков",
                                    fontWeight = FontWeight.W700,
                                    fontSize = 14.sp,
                                    color = LightColorTheme.black
                                )
                                Text(
                                    text = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
                                    fontWeight = FontWeight.W500,
                                    fontSize = 14.sp,
                                    color = LightColorTheme.black,
                                    lineHeight = 17.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(SPACER.SPACER_15.value.dp))
                            FixMyPreviewAvatar(
                                model = "https://s3-alpha-sig.figma.com/img/65dc/6045/b7d9e491ec53bfe994a2cc6f920a0d89?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=OxON~FKl~Hb6L2SXdtsyInwWiSF3-B-ROQu2hDi6vc-fps5T275ecGx0mJb1q1oVrWVKcJFaToFij8RBK1QQ54-8Kh9ncgfvsu4omUntRaQGt1qeHUXuRYtv-sm6rvM5yY5E9T~fU8cw3rc-fEIWJXBcNuOpG6K0wAagMlSO0eVYJzEnecuba85K~zwalhS3gkD4j0sm7hvcrwVoHOcYCaW6KVj58TSksGwu91ht6rHj-x0lnxm0tCU0ZajGVoqmwM7~0XpQhOwfRbWguxEkP-4ApmoN5oGTQmkL7l1aA4Mv9OsZZoUI-JEk58qU6MUeeJ13rstJt6S-JfZFGCqHlg__",
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .size(104.dp)
                                    .weight(1f)
                            )
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        Text(
                            text = "Севкабель Порт, Кожевенная линия, 40",
                            fontWeight = FontWeight.W600,
                            fontSize = 24.sp,
                            color = LightColorTheme.black
                        )
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_metro),
                                contentDescription = null,
                                Modifier.size(20.dp),
                                tint = LightColorTheme.green
                            )
                            Spacer(modifier = Modifier.width(SPACER.SPACER_5.value.dp))
                            Text(
                                text = "Приморская",
                                fontWeight = FontWeight.W500,
                                fontSize = 14.sp,
                                color = LightColorTheme.black
                            )
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        ShowImage(
                            model = "https://s3-alpha-sig.figma.com/img/2665/267b/66f39a9456702ebd75802f466af83f6c?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=aSI-qobzIrqmkfr2ia8iTMaFuCHJhqjzAPlEGB0eQA3Mtj5qImSdGWNY4vJDQSMQbCXkvdKNYv9OvjDV~3bywdP6KNQDh7KSuyb-f4mDsaIEzgUVONU6vMVrPs~8TrY3i2eRIgLR942NgBMFm0Zf9W5zbllK4ZdO1s7~lWvhj71-ed07s2Rbj-FY~fKivEqd7~y5o2lZCXb2I5d~viteZGBpDCGE3-K1nFIeCM7oRvPymWhOFpoe8a3ACQLdVZPBPk~saz1vFTfDmSgYF2~7v8v5fimo67ZIJDZV-rh8KO-2qlzPAsnd6Bkc0gTzGmggvSCFYwBvo4hClLgOqKNLNA__",
                            modifier = Modifier.height(180.dp)
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        Text(
                            text = "Пойдут на встречу",
                            fontWeight = FontWeight.W600,
                            fontSize = 24.sp,
                            color = LightColorTheme.black
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        FixRowAvatars(arrayImage = description.rowAvatars)
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        Text(
                            text = "Организатор",
                            fontWeight = FontWeight.W600,
                            fontSize = 24.sp,
                            color = LightColorTheme.black
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.weight(2f)) {
                                Text(
                                    text = "Разраб",
                                    fontWeight = FontWeight.W700,
                                    fontSize = 14.sp,
                                    color = LightColorTheme.black
                                )
                                Text(
                                    text = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
                                    fontWeight = FontWeight.W500,
                                    fontSize = 14.sp,
                                    color = LightColorTheme.black,
                                    lineHeight = 17.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(SPACER.SPACER_15.value.dp))
                            FixMyPreviewAvatar(
                                model = "https://s3-alpha-sig.figma.com/img/c9a7/54d7/03ba23f3bfdf6a1d3847f7b696a6eedd?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=GPklw6vp2sk5cLXDWVnekLI3NCSHfhK9OXi0eINfUoNrzCVDvPpGe~ns8M4OTi2stt-0106ocpNKqa0vuXUPOSSum97k58KX7wsAuuJOhP0eWo3l3xuhr4ZirrvZzOYEzOFQSTWIte0U-lW-pHp7ayuIQqvdnkixUAw4e~TzZ-GpK6~vOnI1vu8KVDoL72FTeZqpuwNtON-w7Cxt80GXrGX7PsQw0zUffFC-WaePD9sOMt4oxmubUmU7Gywh-rwddqhlxzG-7W4nQ6OtMOBGz8TaJIPGQypqkEuLjMzIDYp6Nh~ZV37wr79J4T92nnLCN8XP9t-jFEsevIkWWbdBUA__",
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .size(104.dp)
                                    .weight(1f)
                            )
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        Text(
                            text = "Другие встречи сообщества",
                            fontWeight = FontWeight.W600,
                            fontSize = 24.sp,
                            color = LightColorTheme.black
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        LazyRow {
                            items(events) { event ->
                                FixCardMeetingMini(
                                    event = event,
                                    onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                        }
                    }
                }
            }
        }
    )
}
