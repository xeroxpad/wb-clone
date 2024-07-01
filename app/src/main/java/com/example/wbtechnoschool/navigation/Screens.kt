package com.example.wbtechnoschool.navigation

enum class Screens {
    ScreenMeeting,
    ScreenCommunity,
    ScreenProfile,
}

sealed class SecondaryScreens(val route: String) {
    data object ScreenProfile: SecondaryScreens("profile_screen")
    data object ScreenMyMeetings: SecondaryScreens("my_meetings")
}