package com.example.wbtechnoschool.screens.community

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.screens.meetings.SelectOtherMeetings
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.avatar.FixMyPreviewAvatar
import com.example.wbtechnoschool.utils.avatar.FixRowAvatars
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER
import com.example.wbtechnoschool.utils.events.FixCardMeeting
import com.example.wbtechnoschool.utils.events.FixCardMeetingMini
import com.example.wbtechnoschool.utils.widgets.GradientToggleButton
import com.example.wbtechnoschool.viewmodel.community_view_model.DetailsCommunityViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.DescriptionMeetingViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenDetailsCommunity(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModelDescriptionMeetings: DescriptionMeetingViewModel = koinViewModel(),
    viewModelMeeting: MeetingViewModel = koinViewModel(),
) {
    val events by viewModelMeeting.meetings.collectAsState()
    val meetingDescription by viewModelDescriptionMeetings.meetingDescription.collectAsState()
    var isButtonPressed by remember { mutableStateOf(false) }
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = "The IT Crowd",
                iconBack = { navController.popBackStack() },
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier =
                Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.Top
            ) {
                item {
                    meetingDescription?.let { description ->
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        Row {
                            FixMyPreviewAvatar(
                                model = "https://s3-alpha-sig.figma.com/img/c9a7/54d7/03ba23f3bfdf6a1d3847f7b696a6eedd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Xmy1lqA1OnC7JfQZwNOzex0EIvJcBJFZM8A03zqhn0ggTfxJuPgrlTeeIE2kr5-xw3HUqXeeJ9hPNdjqIG1gVDLIct53h-vkjBKab6utFh5UUCS3X6N1iuoGg1hLKpVB22~2I8f7y4FDjuJsfoWquMKQWIc55Abds3nllbaKsiAvO-uJvoqw1lfws~XkpNEoW3PR-~bvG6tRfbTSvHUIk9zv~6iSD4QWNaYsrKq2-oxAgvw4jMcGFuu6Mz9em-t-p1AuP5qViY6XeENTWb4y33xRgkmVR62qSkliBWjsIwR0g96f1cLrljuJML3~mOoxupDBpYB8-mAGBG-PxNs59A__",
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .size(167.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        Text(
                            text = "The IT Crowd",
                            fontFamily = fontSFPro,
                            fontWeight = FontWeight.W700,
                            fontSize = 34.sp,
                            color = LightColorTheme.black,
                            lineHeight = 30.sp
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        SelectOtherMeetings(
                            isSelectable = false,
                            tags = listOf(
                                "Разработка",
                                "Карьера",
                                "Тестирование",
                                "Дизайн",
                                "Бизнес",
                            ),
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        GradientToggleButton(
                            textButton = R.string.subscribe,
                            textButtonPress = R.string.you_are_subscribe,
                        ) {
                            isButtonPressed = !isButtonPressed
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_15.value.dp))
                        if (!isButtonPressed) {
                            Text(
                                text = stringResource(id = R.string.invitation_to_meetings_and_communities),
                                color = LightColorTheme.fixVioletBlaze,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500,
                                lineHeight = 18.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        Text(
                            text = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 18.sp
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        Text(
                            text = "Подписаны",
                            fontWeight = FontWeight.W600,
                            fontSize = 24.sp,
                            color = LightColorTheme.black
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        FixRowAvatars(arrayImage = description.rowAvatars) {navController.navigate(Graph.PersonGoingMeeting.route)}
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        Text(
                            text = "Встречи",
                            fontWeight = FontWeight.W600,
                            fontSize = 24.sp,
                            color = LightColorTheme.black
                        )
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                    }
                }
                items(events) { event ->
                    FixCardMeeting(
                        event = event,
                        onClick = {navController.navigate(Graph.DescriptionMeeting.route)},
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
                item {
                    Text(
                        text = "Прошлые встречи",
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.W700,
                        fontSize = 34.sp,
                        color = LightColorTheme.black,
                        lineHeight = 30.sp
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
    )
}
