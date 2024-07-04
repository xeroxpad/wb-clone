package com.example.wbtechnoschool.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.wbtechnoschool.events.Events

@Composable
fun MyPastMeetings() {
    LazyColumn {
        items(8) {
            Events(true)
        }
    }
}