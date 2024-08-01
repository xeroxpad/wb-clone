package com.example.wbtechnoschool.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.infoNavGraph(
    myMoreScreen: @Composable () -> Unit,
    myProfileScreen: @Composable () -> Unit,
    myMeetingsScreen: @Composable () -> Unit,
    myThemeScreen: @Composable () -> Unit,
    myNotificationsScreen: @Composable () -> Unit,
    mySafetyScreen: @Composable () -> Unit,
    myResourcesScreen: @Composable () -> Unit,
    myHelpScreen: @Composable () -> Unit,
    myInviteFriendScreen: @Composable () -> Unit
) {
    navigation(startDestination = Graph.InfoRoot.AllInfo.route, route = Graph.InfoRoot.route) {
        composable(Graph.InfoRoot.AllInfo.route) {
            myMoreScreen()
        }
        composable(Graph.InfoRoot.MyProfile.route) {
            myProfileScreen()
        }
        composable(Graph.InfoRoot.MyMeetings.route) {
            myMeetingsScreen()
        }
        composable(Graph.InfoRoot.MyTheme.route) {
            myThemeScreen()
        }
        composable(Graph.InfoRoot.MyNotifications.route) {
            myNotificationsScreen()
        }
        composable(Graph.InfoRoot.MySafety.route) {
            mySafetyScreen()
        }
        composable(Graph.InfoRoot.MyResources.route) {
            myResourcesScreen()
        }
        composable(Graph.InfoRoot.MyHelp.route) {
            myHelpScreen()
        }
        composable(Graph.InfoRoot.MyInviteFriend.route) {
            myInviteFriendScreen()
        }
    }
}
