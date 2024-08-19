package com.example.wbtechnoschool.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.eventsNavGraph(
    eventsScreen: @Composable () -> Unit,
    meetingsScreenDescription: @Composable () -> Unit,
    communityDetailsScreen: @Composable () -> Unit
) {
    navigation(startDestination = Graph.EventsRoot.AllEvents.route, route = Graph.EventsRoot.route) {
        composable(Graph.EventsRoot.AllEvents.route) {
            eventsScreen()
        }
        composable(Graph.EventsRoot.DescriptionMeetings.route) {
            meetingsScreenDescription()
        }
        composable(Graph.EventsRoot.DetailsCommunity.route) {
            communityDetailsScreen()
        }
    }
}