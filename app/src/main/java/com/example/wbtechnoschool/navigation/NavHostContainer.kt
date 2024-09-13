package com.example.wbtechnoschool.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.wbtechnoschool.screens.auth.ScreenAuthorization
import com.example.wbtechnoschool.screens.auth.ScreenAuthorizationProfile
import com.example.wbtechnoschool.screens.auth.ScreenDeleteProfile
import com.example.wbtechnoschool.screens.auth.ScreenEditInterests
import com.example.wbtechnoschool.screens.auth.ScreenEnteringNumberForAppointment
import com.example.wbtechnoschool.screens.auth.ScreenEntryCode
import com.example.wbtechnoschool.screens.auth.ScreenGetTheCode
import com.example.wbtechnoschool.screens.auth.ScreenMakeAnAppointment
import com.example.wbtechnoschool.screens.auth.ScreenMakeAnAppointmentDone
import com.example.wbtechnoschool.screens.auth.ScreenSelectInterests
import com.example.wbtechnoschool.screens.community.ScreenCommunity
import com.example.wbtechnoschool.screens.community.ScreenDetailsCommunity
import com.example.wbtechnoschool.screens.events.ScreenEvents
import com.example.wbtechnoschool.screens.geodata.ScreenGeoData
import com.example.wbtechnoschool.screens.meetings.ScreenDescriptionMeeting
import com.example.wbtechnoschool.screens.meetings.ScreenMeeting
import com.example.wbtechnoschool.screens.person.ScreenPersonGoingMeeting
import com.example.wbtechnoschool.screens.person.ScreenProfile
import com.example.wbtechnoschool.screens.splash.SplashScreen
import com.example.wbtechnoschool.screens.splash.SplashScreenHelloName

@RequiresApi(Build.VERSION_CODES.O)
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
//                navController.navigate(Graph.Events.route) {
                navController.navigate(Graph.SelectedInterests.route) {
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

        composable(Graph.PersonGoingMeeting.route) {
            ScreenPersonGoingMeeting(navController = navController)
        }

        composable(Graph.SelectedInterests.route) {
            ScreenSelectInterests(navController = navController)
        }

        composable(Graph.MakeAnAppointment.route) {
            ScreenMakeAnAppointment(navController = navController)
        }

        composable(Graph.EnteringNumberForAppointment.route) {
            ScreenEnteringNumberForAppointment(navController = navController)
        }

        composable(Graph.GetTheCode.route) {
            ScreenGetTheCode(navController = navController)
        }

        composable(Graph.MakeAnAppointmentDone.route) {
            ScreenMakeAnAppointmentDone(navController = navController)
        }

        composable(Graph.Events.route) {
            ScreenEvents(navController = navController)
        }

        composable(Graph.EditInterests.route) {
            ScreenEditInterests(navController = navController)
        }

        composable(Graph.DeleteProfile.route) {
            ScreenDeleteProfile(navController = navController)
        }

        composable(Graph.GeoData.route) {
            ScreenGeoData(navController = navController)
        }

        composable(Graph.DescriptionMeeting.route) {
            ScreenDescriptionMeeting(navController = navController)
        }

        composable(Graph.DetailsCommunity.route) {
            ScreenDetailsCommunity(navController = navController)
        }

        composable(
            route = "${Graph.Profile.route}?fromScreen={fromScreen}",
            arguments = listOf(navArgument("fromScreen") { defaultValue = "" })
        ) { backStackEntry ->
            val fromScreen = backStackEntry.arguments?.getString("fromScreen") ?: ""
            ScreenProfile(navController = navController, fromScreen = fromScreen)
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

    }
}
