package com.example.domain.entities

data class Meetings(
    val id: Int,
    val icon: String?,
    val title: String,
    val date: String,
    val city: String,
    val tagDevelopmentLanguage: String,
    val tagGradeDeveloper: String,
    val tagCityMeeting: String,
)

data class FixEvent(
    val id: Int,
    val icon: String?,
    val title: String,
    val date: String,
    val city: String,
    val tagDevelopmentLanguage: String,
    val tagGradeDeveloper: String,
    val tagCityMeeting: String,
)
