package com.example.wbtechnoschool.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.events.CardActiveMeetings
import com.example.wbtechnoschool.events.Meetings
import com.example.wbtechnoschool.navigation.Graph

@Composable
fun MyPastMeetings(navController: NavController) {
    LazyColumn {
        items(8) {
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
        }
    }
}