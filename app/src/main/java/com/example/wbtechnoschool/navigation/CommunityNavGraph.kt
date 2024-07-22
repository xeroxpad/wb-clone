package com.example.wbtechnoschool.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.communityNavGraph(
    communityScreen: @Composable () -> Unit,
    communityDetailsScreen: @Composable () -> Unit,
){
    navigation(startDestination = Graph.CommunityRoot.AllCommunity.route, route = Graph.CommunityRoot.route) {
        composable(Graph.CommunityRoot.AllCommunity.route) {
            communityScreen()
        }
        composable(Graph.CommunityRoot.DetailsCommunity.route) {
            communityDetailsScreen()
        }
    }
}