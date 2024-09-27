package com.example.wbtechnoschool.screens.events

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.room.util.query
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.screens.meetings.SelectOtherMeetings
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.box.InterestSelectionCard
import com.example.wbtechnoschool.utils.events.FixCardCommunity
import com.example.wbtechnoschool.utils.events.FixCardMeeting
import com.example.wbtechnoschool.utils.events.FixCardMeetingMini
import com.example.wbtechnoschool.utils.search.FixSearchTextField
import com.example.wbtechnoschool.viewmodel.community_view_model.CommunityViewModel
import com.example.wbtechnoschool.viewmodel.events_view_model.EventsViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenEvents(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModelMeeting: MeetingViewModel = koinViewModel(),
    viewModelCommunity: CommunityViewModel = koinViewModel(),
    viewModelEvents: EventsViewModel = koinViewModel(),
) {
    val meetings by viewModelEvents.meetings.collectAsStateWithLifecycle()
    val community by viewModelCommunity.community.collectAsStateWithLifecycle()
    val focusManager = LocalFocusManager.current
    var searchQuery by remember { mutableStateOf("") }
    val filteredMeetings by viewModelEvents.filteredMeetings.collectAsStateWithLifecycle()
    LaunchedEffect(searchQuery) {
        viewModelEvents.searchMeetings(searchQuery)
    }

    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            }
            .fillMaxSize(),
        content = { innerPadding ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .height(44.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FixSearchTextField(
                    placeholder = R.string.search_meetings_and_community,
                    modifier = Modifier
                        .weight(3f),
                    leadingIcon = R.drawable.search,
                    onValueChange = { query ->
                        searchQuery = query
                    }
                )
                Spacer(
                    modifier = Modifier
                        .width(10.dp)
                )
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .size(44.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .clickable { navController.navigate("${Graph.Profile.route}?fromScreen=${Graph.Events.route}") },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_user),
                        contentDescription = null,
                        tint = LightColorTheme.fixVioletBlaze,
                    )
                }
            }
            LazyColumn(
                modifier =
                Modifier
                    .padding(start = 20.dp)
                    .padding(innerPadding)
                    .padding(top = 60.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
            ) {
                item {
                    AnimatedVisibility(
                        visible = filteredMeetings.isNotEmpty(),
                        enter = fadeIn(animationSpec = tween(1000)),
                        exit = fadeOut(animationSpec = tween(1000))
                    ) {
                        LazyRow {
                            items(filteredMeetings) { meeting ->
                                FixCardMeeting(
                                    event = meeting,
                                    onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                            }
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
                        items(filteredMeetings) { meeting ->
                            FixCardMeetingMini(
                                event = meeting,
                                onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
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
                        items(20) {
                            FixCardCommunity(
                                community = community,
                                onClick = { navController.navigate(Graph.DetailsCommunity.route) },
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Другие встречи",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W600,
                        color = LightColorTheme.black,
                    )
                    Spacer(modifier = Modifier.height(15.dp))
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
                }
                items(filteredMeetings) { meeting ->
                    FixCardMeeting(
                        event = meeting,
                        onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                }
                item {
                    InterestSelectionCard(
                        modifier = Modifier.padding(end = 20.dp),
                        onClick = { navController.navigate(Graph.EditInterests.route) })
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    )
}