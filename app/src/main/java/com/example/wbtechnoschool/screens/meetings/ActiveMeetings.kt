package com.example.wbtechnoschool.screens.meetings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.domain.entities.Meetings
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.utils.events.CardActiveMeetings
import com.example.wbtechnoschool.navigation.Graph

@Composable
fun ActiveMeetings(navController: NavController) {
    LazyColumn {
        items(15) {
            CardActiveMeetings(
                onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
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