package com.example.wbtechnoschool.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wbtechnoschool.features.ContainerToGo
import com.example.wbtechnoschool.screens.ActiveMeetings
import com.example.wbtechnoschool.screens.AllMeetings
import com.example.wbtechnoschool.screens.MyPastMeetings
import com.example.wbtechnoschool.screens.MyPlannedMeetings
import com.example.wbtechnoschool.screens.ScreenCommunity
import com.example.wbtechnoschool.screens.ScreenHelp
import com.example.wbtechnoschool.screens.ScreenInfo
import com.example.wbtechnoschool.screens.ScreenInviteFriend
import com.example.wbtechnoschool.screens.ScreenMeeting
import com.example.wbtechnoschool.screens.ScreenMyMeetings
import com.example.wbtechnoschool.screens.ScreenNotifications
import com.example.wbtechnoschool.screens.ScreenProfile
import com.example.wbtechnoschool.screens.ScreenResources
import com.example.wbtechnoschool.screens.ScreenSafety
import com.example.wbtechnoschool.screens.ScreenTheme

@Composable
fun NavHostContainer(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ScreenMeeting.name,
        modifier = modifier
    ){
        composable(route = Screens.ScreenMeeting.name) {
            ScreenMeeting()
        }
        composable(route = Screens.ScreenCommunity.name) {
            ScreenCommunity()
        }
        composable(route = Screens.ScreenProfile.name) {
            ScreenInfo(navController)
        }
        composable("screen_profile") {
            ScreenProfile(navController)
        }
        composable("icon_screen_profile") {
            ScreenInfo(navController)
        }
        composable("screen_my_meetings") {
            ScreenMyMeetings(navController)
        }
        composable("icon_screen_my_meetings") {
            ScreenInfo(navController)
        }
        composable("screen_theme") {
            ScreenTheme()
        }
        composable("screen_notifications") {
            ScreenNotifications()
        }
        composable("screen_safety") {
            ScreenSafety()
        }
        composable("screen_resources") {
            ScreenResources()
        }
        composable("screen_help") {
            ScreenHelp()
        }
        composable("screen_invite_friend") {
            ScreenInviteFriend()
        }
    }
}