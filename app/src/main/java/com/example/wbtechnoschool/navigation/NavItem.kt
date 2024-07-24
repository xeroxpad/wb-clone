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
        route = Graph.MeetingsRoot.route,
    )

    data object CommunityElement : NavItem(
        description = "Сообщества",
        icon = R.drawable.community,
        route = Graph.CommunityRoot.route,
    )

    data object InfoElement : NavItem(
        description = "Еще",
        icon = R.drawable.info,
        route = Graph.InfoRoot.route,
    )
}

val listRootElement = listOf(
    NavItem.MeetingElement,
    NavItem.CommunityElement,
    NavItem.InfoElement
)



