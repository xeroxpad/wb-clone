package com.example.wbtechnoschool.screens.meetings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.domain.entities.Meetings
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.utils.events.CardActiveMeetings
import com.example.wbtechnoschool.utils.events.CardCompletedMeetings
import com.example.wbtechnoschool.navigation.Graph

@Composable
fun MyPlannedMeetings(navController: NavController) {
    LazyColumn {
        items(6) {
            CardActiveMeetings(
                onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                meetings = Meetings(
                    id = 3,
                    icon = "https://thumbs.dreamstime.com/b/minimalist-twin-coffee-code-logo-design-template-163374058.jpg",
                    title = "Developer meeting",
                    date = stringResource(id = R.string.date_meeting),
                    city = stringResource(id = R.string.location_meeting),
                    tagDevelopmentLanguage = "Kotlin",
                    tagGradeDeveloper = "Junior",
                    tagCityMeeting = "Moscow",
                )
            )
            CardCompletedMeetings(
                onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                meetings = Meetings(
                    id = 4,
                    icon = "https://thumbs.dreamstime.com/b/minimalist-twin-coffee-code-logo-design-template-163374058.jpg",
                    title = "Developer meeting",
                    date = stringResource(id = R.string.date_meeting),
                    city = stringResource(id = R.string.location_meeting),
                    tagDevelopmentLanguage = "Kotlin",
                    tagGradeDeveloper = "Junior",
                    tagCityMeeting = "Moscow",
                )
            )
        }
    }
}