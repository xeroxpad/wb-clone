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
import com.example.wbtechnoschool.screens.splash.SplashScreen
import com.example.wbtechnoschool.screens.splash.SplashScreenHelloName

@Composable
fun NavHostContainer(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    meetingsScreen: @Composable () -> Unit,
    meetingsScreenDescription: @Composable () -> Unit,
    communityScreen: @Composable () -> Unit,
    communityDetailsScreen: @Composable () -> Unit,
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
    NavHost(
        navController = navController,
        startDestination = Graph.Splash.route
    ) {
        meetingsNavGraph(
            meetingsScreen = meetingsScreen,
            meetingsScreenDescription = meetingsScreenDescription
        )
        communityNavGraph(
            communityScreen = communityScreen,
            communityDetailsScreen = communityDetailsScreen
        )
        infoNavGraph(
            myMoreScreen = myMoreScreen,
            myProfileScreen = myProfileScreen,
            myMeetingsScreen = myMeetingsScreen,
            myThemeScreen = myThemeScreen,
            myNotificationsScreen = myNotificationsScreen,
            mySafetyScreen = mySafetyScreen,
            myResourcesScreen = myResourcesScreen,
            myHelpScreen = myHelpScreen,
            myInviteFriendScreen = myInviteFriendScreen
        )
        composable(Graph.Splash.route) {
            SplashScreen { navController.navigate(Graph.Authorization.route) { popUpTo(Graph.Splash.route) { inclusive = true } } }
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
                    }
                }
            )
        }
    }
}
