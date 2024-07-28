package com.example.domain.entities

data class MeetingsDescription(
    val id: Int,
    val title: String,
    val dateAndLocation: String,
    val tags: List<String>,
    val map: String,
    val description: String,
    val rowAvatars: List<String>
)
