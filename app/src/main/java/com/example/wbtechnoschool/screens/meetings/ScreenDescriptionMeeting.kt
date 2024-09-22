package com.example.wbtechnoschool.screens.meetings

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.avatar.FixMyPreviewAvatar
import com.example.wbtechnoschool.utils.avatar.FixRowAvatars
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER
import com.example.wbtechnoschool.utils.events.FixCardMeetingMini
import com.example.wbtechnoschool.utils.tags.FixFilterTags
import com.example.wbtechnoschool.utils.widgets.GradientToggleButton
import com.example.wbtechnoschool.utils.widgets.ShowImage
import com.example.wbtechnoschool.viewmodel.meetings_view_model.DescriptionMeetingViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenDescriptionMeeting(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DescriptionMeetingViewModel = koinViewModel(),
    viewModelMeeting: MeetingViewModel = koinViewModel(),
) {
    val meetingDescription by viewModel.meetingDescription.collectAsStateWithLifecycle()
    val events by viewModelMeeting.meetings.collectAsStateWithLifecycle()
    var isButtonPressed by remember { mutableStateOf(false) }
    val meetingIsOver by remember { mutableStateOf(true) }
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                modifier = Modifier.padding(horizontal = 10.dp),
                title = "Как повышать грейд. Лекция Павла Хорикова",
                iconBack = { navController.popBackStack() },
            )
        },
        bottomBar = {
            if (meetingIsOver) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black.copy(alpha = 0.5f),
                                )
                            )
                        )
                        .clip(shape = RoundedCornerShape(topStart = 14.dp, topEnd = 14.dp))
                        .padding(top = 13.dp)
                        .zIndex(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                            .background(Color.White)
                            .zIndex(2f),
                        contentAlignment = Alignment.Center,
                    ) {
                        Column {
                            Text(
                                text = if (isButtonPressed) "✔ Вы пойдёте" else "Всего 30 мест. Если передумаете — отпишитесь",
                                color = if (isButtonPressed) LightColorTheme.green else LightColorTheme.fixVioletBlaze,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500,
                                modifier = Modifier
                                    .padding(vertical = 7.dp, horizontal = 5.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                            GradientToggleButton(
                                modifier = Modifier
                                    .padding(bottom = 20.dp)
                                    .padding(horizontal = 20.dp),
                                navController = navController,
                                textButton = R.string.go_to_the_meetings,
                                textButtonPress = R.string.go_another_time_meetings,
                            ) {
                                isButtonPressed = !isButtonPressed
                                navController.navigate(Graph.MakeAnAppointment.route)
                            }
                        }
                    }
                }
            }
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
                    ) { },
                verticalArrangement = Arrangement.Top
            ) {
                item {
                    meetingDescription?.let { description ->
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        ShowImage(model = "https://picsum.photos/200/300?random")
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        Text(
                            text = "Как повышать грейд. Лекция Павла Хорикова",
                            fontFamily = fontSFPro,
                            fontWeight = FontWeight.W700,
                            fontSize = 34.sp,
                            color = LightColorTheme.black,
                            lineHeight = 34.sp
                        )
                        Row {
                            Text(
                                text = "${description.dateMeeting}, ${description.timeMeeting} · ${description.locationMeeting}",
                                fontFamily = fontSFPro,
                                fontWeight = FontWeight.W600,
                                fontSize = MagicNumbers.SCREEN_DESCRIPTION_ROW_TEXT_FONT_SIZE.sp,
                                color = LightColorTheme.neutralWeak
                            )
                        }
                        Row {
                            description.tagsMeeting.split(",").forEach { tag ->
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
                            text = description.descriptionMeeting,
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
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(12.dp))
                                .clickable {}
                        ) {
                            Column(modifier = Modifier.weight(2f)) {
                                Text(
                                    text = description.leaderMeeting,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 14.sp,
                                    color = LightColorTheme.black
                                )
                                Text(
                                    text = description.leaderInfoMeeting,
                                    fontWeight = FontWeight.W500,
                                    fontSize = 14.sp,
                                    color = LightColorTheme.black,
                                    lineHeight = 17.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(SPACER.SPACER_15.value.dp))
                            Box(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .weight(1f)
                                    .size(104.dp)
                            ) {
                                FixMyPreviewAvatar(
                                    model = description.leaderAvatar ?: "",
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                        Text(
                            text = description.locationMeeting,
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
                                text = description.titleMetroStation ?: "",
                                fontWeight = FontWeight.W500,
                                fontSize = 14.sp,
                                color = LightColorTheme.black
                            )
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        ShowImage(
                            model = description.mapMeeting,
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
                        FixRowAvatars(arrayImage = description.visitorsMeeting) {
                            navController.navigate(
                                Graph.PersonGoingMeeting.route
                            )
                        }
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
                                    text = description.titleCommunityMeeting,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 14.sp,
                                    color = LightColorTheme.black
                                )
                                Text(
                                    text = description.descriptionCommunityMeeting,
                                    fontWeight = FontWeight.W500,
                                    fontSize = 14.sp,
                                    color = LightColorTheme.black,
                                    lineHeight = 17.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(SPACER.SPACER_15.value.dp))
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .size(104.dp)
                                    .clip(shape = RoundedCornerShape(16.dp))
                            ) {
                                FixMyPreviewAvatar(
                                    model = description.iconCommunityMeeting ?: "",
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxSize()
                                )
                                if (description.isSubscribedCommunity) {
                                    Box(
                                        modifier = Modifier
                                            .padding(7.dp)
                                            .size(37.dp)
                                            .clip(shape = RoundedCornerShape(12.dp))
                                            .background(LightColorTheme.blushPink)
                                            .align(Alignment.BottomStart),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_check),
                                            contentDescription = null,
                                            tint = LightColorTheme.fixBrandColorDark
                                        )
                                    }
                                }
                            }

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
                            items(15) {
                                FixCardMeetingMini(
                                    event = events,
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
