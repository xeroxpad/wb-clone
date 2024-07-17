package com.example.wbtechnoschool.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.wbtechnoschool.screens.auth.ScreenAuthorization
import com.example.wbtechnoschool.screens.auth.ScreenAuthorizationProfile
import com.example.wbtechnoschool.screens.community.ScreenCommunity
import com.example.wbtechnoschool.screens.meetings.ScreenDescriptionMeeting
import com.example.wbtechnoschool.screens.community.ScreenDetailsCommunity
import com.example.wbtechnoschool.screens.auth.ScreenEntryCode
import com.example.wbtechnoschool.screens.more.help.ScreenHelp
import com.example.wbtechnoschool.screens.more.ScreenInfo
import com.example.wbtechnoschool.screens.more.invite_friend.ScreenInviteFriend
import com.example.wbtechnoschool.screens.meetings.ScreenMeeting
import com.example.wbtechnoschool.screens.more.my_meetings.ScreenMyMeetings
import com.example.wbtechnoschool.screens.more.notifications.ScreenNotifications
import com.example.wbtechnoschool.screens.more.profile.ScreenProfile
import com.example.wbtechnoschool.screens.more.resources.ScreenResources
import com.example.wbtechnoschool.screens.more.safety.ScreenSafety
import com.example.wbtechnoschool.screens.more.theme.ScreenTheme
import com.example.wbtechnoschool.screens.splash.SplashScreen
import com.example.wbtechnoschool.screens.splash.SplashScreenHelloName

@Composable
fun NavHostContainer(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Graph.splashScreen,
    ){
        composable(Graph.screenMeeting) {
            ScreenMeeting(navController = navController)
        }
        composable(Graph.screenCommunity) {
            ScreenCommunity(navController = navController)
        }
        composable(Graph.screenInfo) {
            ScreenInfo(navController)
        }
        composable(Graph.screenProfile) {
            ScreenProfile(navController)
        }
        composable(Graph.screenMyMeetings) {
            ScreenMyMeetings(navController = navController)
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
            ScreenResources(navController)
        }
        composable(Graph.screenHelp) {
            ScreenHelp(navController)
        }
        composable(Graph.inviteFriend) {
            ScreenInviteFriend()
        }
        composable(Graph.screenDetailsCommunity) {
            ScreenDetailsCommunity(navController = navController)
        }
        composable(Graph.screenDescriptionMeeting) {
            ScreenDescriptionMeeting(navController)
        }
        composable(Graph.splashScreen) {
            SplashScreen{navController.navigate(Graph.screenAuthorization) {popUpTo(Graph.splashScreen) {inclusive = true}}}
        }
        composable(Graph.screenAuthorization) {
            ScreenAuthorization(navController = navController,)
        }
        composable(
            route = "${Graph.screenEntryCode}/{phoneNumber}",
            arguments = listOf(navArgument("phoneNumber") {type = NavType.StringType})
        ) { backStackEntry ->
            ScreenEntryCode(
                navController = navController,
                phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: "",
            )
        }
        composable(Graph.screenAuthorizationProfile) {
            ScreenAuthorizationProfile(navController = navController)
        }
        composable(
            route = "${Graph.screenSplashHelloName}/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            SplashScreenHelloName(
                name = backStackEntry.arguments?.getString("name") ?: "",
                onTimeout = {
                    navController.navigate(Graph.screenMeeting) {
                        popUpTo(Graph.screenSplashHelloName) { inclusive = true }
                    }
                }
            )
        }
    }
}