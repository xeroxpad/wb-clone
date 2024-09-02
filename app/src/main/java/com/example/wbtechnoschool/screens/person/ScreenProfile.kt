package com.example.wbtechnoschool.screens.person

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.domain.entities.FixEvent
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.screens.meetings.SelectOtherMeetings
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.avatar.FixMyAvatar
import com.example.wbtechnoschool.utils.box.Network
import com.example.wbtechnoschool.utils.button.StatusTextButton
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.events.FixCardCommunity
import com.example.wbtechnoschool.utils.events.FixCardMeeting
import com.example.wbtechnoschool.utils.events.FixCardMeetingMini
import com.example.wbtechnoschool.utils.search.FixSearchTextField
import com.example.wbtechnoschool.utils.tags.FixTags
import com.example.wbtechnoschool.viewmodel.community_view_model.CommunityViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ScreenProfile(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModelMeeting: MeetingViewModel = koinViewModel(),
    viewModelCommunity: CommunityViewModel = koinViewModel(),
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
        topBar = {
            MainTopAppBar(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .background(Color.Transparent),
                title = "",
                iconBack = { navController.popBackStack() },
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier =
                Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
            ) {
                item {
                    Box(modifier = Modifier
                        .offset(y = (-innerPadding.calculateTopPadding()).coerceAtLeast(0.dp))
                        .fillMaxWidth()
                        .clickable { }
                        .height(375.dp)) {
                        FixMyAvatar(
                            model = R.drawable.avatars,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                    Column(modifier = Modifier.padding(start = 20.dp)) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Михаил",
                            fontSize = 49.sp,
                            fontWeight = FontWeight.W600,
                        )
                        Text(
                            text = "Москва",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W600,
                        )
                        Row(modifier = Modifier.padding(end = 20.dp)) {
                            Text(
                                text = "Занимаюсь разрабокой мобильных приложений. Учусь в техношколе Wildberries. Изучаю язык Kotlin",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W600,
                                lineHeight = 14.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        FlowRow(
                            modifier = modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            FixTags(
                                labelText = "Разработка",
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            FixTags(
                                labelText = "Безопасность",
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            FixTags(
                                labelText = "Девопс",
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            FixTags(
                                labelText = "Backend",
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            FixTags(
                                labelText = "Mobile",
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            FixTags(
                                labelText = "Тестирование",
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            FixTags(
                                labelText = "Аналитика",
                                modifier = Modifier.padding(end = 5.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Network(icon = R.drawable.icon_habr)
                            Network(icon = R.drawable.icon_telegram)
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "Мои встречи",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.W600,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        LazyRow {
                            items(events) { event ->
                                FixCardMeetingMini(
                                    event = event,
                                    onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "Мои сообщества",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.W600,
                            modifier = Modifier.padding(end = 20.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        LazyRow {
                            items(community) { communities ->
                                FixCardCommunity(
                                    community = communities,
                                    onClick = { navController.navigate(Graph.DetailsCommunity.route) },
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Row(
                            modifier = Modifier
                                .padding(end = 20.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            StatusTextButton(
                                contentColor = LightColorTheme.indigoTwilight,
                                containerColor = Color.Transparent,
                                enable = true,
                                onClick = { /*TODO*/ },
                                contentText = stringResource(id = R.string.log_out)
                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
            }
        }
    )
}


   