package com.example.wbtechnoschool.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
        startDestination = Graph.screenMeeting,
        modifier = modifier
    ){
        composable(Graph.screenMeeting) {
            ScreenMeeting()
        }
        composable(Graph.screenCommunity) {
            ScreenCommunity()
        }
        composable(Graph.screenInfo) {
            ScreenInfo(navController)
        }
        composable(Graph.screenProfile) {
            ScreenProfile(navController)
        }
        composable(Graph.screenMyMeetings) {
            ScreenMyMeetings(navController)
        }
        composable(Graph.screenTheme) {
            ScreenTheme()
        }
        composable(Graph.screenNotifications) {
            ScreenNotifications()
        }
        composable(Graph.screenSafety) {
            ScreenSafety(navController)
        }
        composable(Graph.screenResources) {
            ScreenResources()
        }
        composable(Graph.screenHelp) {
            ScreenHelp()
        }
        composable(Graph.inviteFriend) {
            ScreenInviteFriend()
        }
//        composable(
//            "profile/{avatarUri}",
//            arguments = listOf(navArgument("avatarUri") { type = NavType.StringType })
//        ) { backStackEntry ->
//            ScreenProfile(backStackEntry.arguments?.getString("avatarUri"), navController)
//        }
    }
}