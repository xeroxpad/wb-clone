package com.example.wbtechnoschool.navigation

import com.example.wbtechnoschool.R

sealed class NavItem(
    val description: String,
    val icon: Int?,
    val route: String,
) {
    data object MeetingElement: NavItem(
        description = "Встречи",
        icon = R.drawable.meeting,
        route = Graph.screenMeeting,
    )

    data object CommunityElement : NavItem(
        description = "Сообщества",
        icon = R.drawable.community,
        route = Graph.screenCommunity,
    )

    data object InfoElement : NavItem(
        description = "Еще",
        icon = R.drawable.info,
        route = Graph.screenInfo,
    )
}

val listRootElement = listOf(
    NavItem.MeetingElement,
    NavItem.CommunityElement,
    NavItem.InfoElement
)




