package com.example.wbtechnoschool.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.wbtechnoschool.events.Events

@Composable
fun AllMeetings() {
    LazyColumn {
        items(15) {
            Events(true)
        }
    }
}