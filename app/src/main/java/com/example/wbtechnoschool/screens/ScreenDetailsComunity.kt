package com.example.wbtechnoschool.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.events.CardActiveMeetings
import com.example.wbtechnoschool.events.CardCompletedMeetings
import com.example.wbtechnoschool.events.Meetings
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum

@Composable
fun ScreenDetailsCommunity(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = "Designa",
                iconBack = { navController.popBackStack() },
            )
        }, content = { innerPadding ->
            var showMoreText by remember { mutableStateOf(false) }
            LazyColumn(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .padding(innerPadding)
                    .navigationBarsPadding()
                    .fillMaxSize()
                    .animateContentSize(animationSpec = tween(100))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { showMoreText = !showMoreText },
                verticalArrangement = Arrangement.Top,
            ) {
                item(1) {
                    val lorem: Lorem = LoremIpsum()
                    val loremText = lorem.getWords(100, 200)
                    if (showMoreText) {
                        Text(
                            text = loremText,
                            fontSize = 12.sp,
                            fontFamily = fontSFPro,
                            fontWeight = FontWeight.W400,
                            color = LightColorTheme.neutralWeak
                        )
                    } else {
                        Text(
                            text = loremText,
                            fontSize = 12.sp,
                            fontFamily = fontSFPro,
                            fontWeight = FontWeight.W400,
                            color = LightColorTheme.neutralWeak,
                            maxLines = 13,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = stringResource(id = R.string.meetings_community),
                        fontSize = 14.sp,
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.W600,
                        color = LightColorTheme.neutralWeak
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
                items(18) {
                    CardActiveMeetings(
                        onClick = { navController.navigate(Graph.screenDescriptionMeeting) },
                        meetings = Meetings(
                            icon = R.drawable.avatar_preview,
                            title = "Developer meeting",
                            date = R.string.date_meeting,
                            city = R.string.location_meeting,
                            tagDevelopmentLanguage = "Kotlin",
                            tagGradeDeveloper = "Junior",
                            tagCityMeeting = "Moscow",
                        )
                    )
                    CardCompletedMeetings(
                        meetings = Meetings(
                            icon = R.drawable.avatar_preview,
                            title = "Developer meeting",
                            date = R.string.date_meeting,
                            city = R.string.location_meeting,
                            tagDevelopmentLanguage = "Kotlin",
                            tagGradeDeveloper = "Junior",
                            tagCityMeeting = "Moscow",
                        )
                    )
                }
            }
        }
    )
}