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
import com.example.wbtechnoschool.screens.auth.ScreenEntryCode
import com.example.wbtechnoschool.screens.community.ScreenCommunity
import com.example.wbtechnoschool.screens.community.ScreenDetailsCommunity
import com.example.wbtechnoschool.screens.events.ScreenEvents
import com.example.wbtechnoschool.screens.meetings.ScreenDescriptionMeeting
import com.example.wbtechnoschool.screens.meetings.ScreenMeeting
import com.example.wbtechnoschool.screens.more.ScreenInfo
import com.example.wbtechnoschool.screens.more.help.ScreenHelp
import com.example.wbtechnoschool.screens.more.invite_friend.ScreenInviteFriend
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
        startDestination = Graph.Splash.route
    ) {
//        composable(Graph.Splash.route) {
//            SplashScreen {
//                navController.navigate(Graph.Authorization.route) {
//                    popUpTo(Graph.Splash.route) {
//                        inclusive = true
//                    }
//                }
//            }
//        }
        composable(Graph.Splash.route) {
            SplashScreen {
                navController.navigate(Graph.Events.route) {
                    popUpTo(Graph.Splash.route) {
                        inclusive = true
                    }
                }
            }
        }
        composable(Graph.Authorization.route) {
            ScreenAuthorization(navController = navController)
        }
        composable(
            route = "${Graph.EntryCode.route}/{phoneNumber}",
            arguments = listOf(navArgument("phoneNumber") { type = NavType.StringType })
        ) { backStackEntry ->
            ScreenEntryCode(
                navController = navController,
                phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
            )
        }
        composable(Graph.AuthorizationProfile.route) {
            ScreenAuthorizationProfile(navController = navController)
        }
        composable(
            route = "${Graph.SplashHelloName.route}/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            SplashScreenHelloName(
                name = backStackEntry.arguments?.getString("name") ?: "",
                onTimeout = {
                    navController.navigate(Graph.Meetings.route) {
                        popUpTo(Graph.SplashHelloName.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
        eventsNavGraph(
            eventsScreen = { ScreenEvents(navController = navController) },
            meetingsScreenDescription = { ScreenDescriptionMeeting(navController = navController) },
            communityDetailsScreen = { ScreenDetailsCommunity(navController = navController) }
        )
        meetingsNavGraph(
            meetingsScreen = { ScreenMeeting(navController = navController) },
            meetingsScreenDescription = { ScreenDescriptionMeeting(navController = navController) }
        )
        communityNavGraph(
            communityScreen = { ScreenCommunity(navController = navController) },
            communityDetailsScreen = { ScreenDetailsCommunity(navController = navController) }
        )
        infoNavGraph(
            myMoreScreen = {ScreenInfo(navController = navController) },
            myProfileScreen = {ScreenProfile(navController = navController) },
            myMeetingsScreen = { ScreenMyMeetings(navController = navController) },
            myThemeScreen = { ScreenTheme() },
            myNotificationsScreen = { ScreenNotifications() },
            mySafetyScreen = { ScreenSafety(navController = navController) },
            myResourcesScreen = { ScreenResources(navController = navController) },
            myHelpScreen = { ScreenHelp(navController = navController) },
            myInviteFriendScreen = { ScreenInviteFriend() }
        )
    }
}
