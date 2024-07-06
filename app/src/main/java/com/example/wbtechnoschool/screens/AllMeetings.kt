package com.example.wbtechnoschool.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.wbtechnoschool.events.CardActiveMeetings
import com.example.wbtechnoschool.events.CardCompletedMeetings
import com.example.wbtechnoschool.navigation.Graph

@Composable
fun AllMeetings(navController: NavController) {
    LazyColumn {
        items(15) {
            CardActiveMeetings(onClick = {navController.navigate(Graph.screenDescriptionMeeting)})
            CardCompletedMeetings()
        }
    }
}