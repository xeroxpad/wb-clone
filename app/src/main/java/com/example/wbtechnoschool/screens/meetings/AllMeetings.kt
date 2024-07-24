package com.example.wbtechnoschool.screens.meetings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.wbtechnoschool.utils.events.CardActiveMeetings
import com.example.wbtechnoschool.utils.events.CardCompletedMeetings
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AllMeetings(navController: NavController, viewModel: MeetingViewModel = koinViewModel()) {
    val meetings by viewModel.meetings.collectAsState()
    LazyColumn {
        items(meetings) { meeting ->
            CardActiveMeetings(
                onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                meetings = meeting
            )
            CardCompletedMeetings(
                onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                meetings = meeting
            )
        }
    }
}