package com.example.wbtechnoschool.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.meetingsNavGraph(
    meetingsScreen: @Composable () -> Unit,
    meetingsScreenDescription: @Composable () -> Unit,
) {
    navigation(startDestination = Graph.MeetingsRoot.AllMeetings.route, route = Graph.MeetingsRoot.route) {
        composable(Graph.MeetingsRoot.AllMeetings.route) {
            meetingsScreen()
        }
        composable(Graph.MeetingsRoot.DescriptionMeetings.route) {
            meetingsScreenDescription()
        }
    }
}