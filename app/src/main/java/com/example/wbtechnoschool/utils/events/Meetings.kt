package com.example.wbtechnoschool.utils.events

@Deprecated("этот класс в другом модуле, пока оставлю на всякий случай")
data class Meetings(
    val icon: Int,
    val title: String,
    val date: Int,
    val city: Int,
    val tagDevelopmentLanguage: String,
    val tagGradeDeveloper: String,
    val tagCityMeeting: String,
)
