package com.example.wbtechnoschool.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.wbtechnoschool.events.Events

@Composable
fun ActiveMeetings() {
    LazyColumn {
        items(15) {
            Events(false)
        }
    }
}