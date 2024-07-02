package com.example.wbtechnoschool.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.wbtechnoschool.events.Events

@Composable
fun MyPlannedMeetings() {
    LazyColumn {
        items(6) {
            Events(false)
        }
    }
}