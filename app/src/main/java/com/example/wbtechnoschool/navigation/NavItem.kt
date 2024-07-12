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
            description = "Встречи",
            icon = R.drawable.meeting,
            route = Graph.screenMeeting
        ),
        NavItem(
            description = "Сообщества",
            icon = R.drawable.community,
            route = Graph.screenCommunity
        ),
        NavItem(
            description = "Еще",
            icon = R.drawable.info,
            route = Graph.screenInfo
        )
    )
}

