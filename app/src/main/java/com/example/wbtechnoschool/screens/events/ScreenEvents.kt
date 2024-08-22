package com.example.wbtechnoschool.screens.events

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.screens.meetings.SelectOtherMeetings
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.button.PaymentButton
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.events.FixCardCommunity
import com.example.wbtechnoschool.utils.events.FixCardMeeting
import com.example.wbtechnoschool.utils.events.FixCardMeetingMini
import com.example.wbtechnoschool.utils.search.FixSearchTextField
import com.example.wbtechnoschool.viewmodel.community_view_model.CommunityViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenEvents(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModelMeeting: MeetingViewModel = koinViewModel(),
    viewModelCommunity: CommunityViewModel = koinViewModel()
) {
    val events by viewModelMeeting.meetings.collectAsState()
    val community by viewModelCommunity.community.collectAsState()
    val focusManager = LocalFocusManager.current
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            }
            .fillMaxSize(),
        content = { innerPadding ->
            Row(modifier = Modifier.padding(horizontal = 20.dp)) {
                FixSearchTextField(
                    placeholder = R.string.search_meetings_and_community,
                    modifier = Modifier
                        .weight(1f),
                )
            }
            LazyColumn(
                modifier =
                Modifier
                    .padding(start = 20.dp)
                    .padding(innerPadding)
                    .padding(top = MagicNumbers.SCREEN_COMMUNITY_LAZY_PADDING_TOP.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
            ) {
                item {
                    LazyRow {
                        items(events) { event ->
                            FixCardMeeting(
                                event = event,
                                onClick = {navController.navigate(Graph.DescriptionMeeting.route)},
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = stringResource(id = R.string.upcoming_meetings),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W600,
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    LazyRow {
                        items(events) { event ->
                            FixCardMeetingMini(
                                event = event,
                                onClick = {navController.navigate(Graph.DescriptionMeeting.route)},
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Сообщества для тестировщиков",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W600,
                        modifier = Modifier.padding(end = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    LazyRow {
                        items(community) { communities ->
                            FixCardCommunity(
                                community = communities,
                                onClick = {},
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    SelectOtherMeetings(
                        tags = listOf(
                            "Дизайн",
                            "Разработка",
                            "Продакт менеджмент",
                            "Проджект менеджмент",
                            "Backend",
                            "Frontend",
                            "Mobile",
                            "Web",
                            "Тестирование",
                            "Продажи",
                            "Бизнес",
                            "Маркетинг",
                            "Безопасность",
                            "Девопс",
                            "Аналитика",
                            "Все категории"
                        )
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    PaymentButton(
                        background = listOf(
                            LightColorTheme.fixBlushPink,
                            LightColorTheme.fixFuchsiaGlow,
                            LightColorTheme.fixVividViolet,
                            LightColorTheme.fixElectricViolet,
                            LightColorTheme.fixRadiantMagenta,
                            LightColorTheme.fixVioletBlaze,
                            LightColorTheme.fixNeonLavender,
                            LightColorTheme.fixRoyalIndigo
                        ),
                        enable = true,
                        onClick = { /*TODO*/ },
                        contentText = "Оплатить",
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(MagicNumbers.BUTTON_SHAPE))
                            .padding(end = 20.dp)
                            .fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    )
}