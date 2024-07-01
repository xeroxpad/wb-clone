package com.example.wbtechnoschool.navigation

import com.example.wbtechnoschool.R

data class NavItem(
    val description: String,
    val icon: Int,
    val route: String
)

object Element{
    val listOfNavItems = listOf(
        NavItem(
            description = "",
            icon = R.drawable.meeting,
            route = Screens.ScreenMeeting.name
        ),
        NavItem(
            description = "",
            icon = R.drawable.community,
            route = Screens.ScreenCommunity.name
        ),
        NavItem(
            description = "",
            icon = R.drawable.info,
            route = Screens.ScreenProfile.name
        )
    )
}

