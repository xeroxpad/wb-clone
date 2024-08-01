package com.example.wbtechnoschool.navigation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbtechnoschool.screens.community.ScreenCommunity
import com.example.wbtechnoschool.screens.community.ScreenDetailsCommunity
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

@Composable
fun StartScreen(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val baseRoute = currentRoute?.substringBefore("/") ?: ""
    val bottomBarIsShow = rememberSaveable { (mutableStateOf(true)) }
// тут с навигацией фигня, поправлю
    bottomBarIsShow.value =
        when (baseRoute) {
            Graph.Splash.route,
            Graph.Authorization.route,
            Graph.EntryCode.route,
            Graph.AuthorizationProfile.route,
            Graph.SplashHelloName.route
            -> false
            else -> true
        }
    Scaffold(bottomBar = {
        when {
            bottomBarIsShow.value -> {
                BottomNavBar(navController = navController, modifier = Modifier.navigationBarsPadding())
            }
        }
    }) { innerPadding ->
        NavHostContainer(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            meetingsScreen = { ScreenMeeting(navController = navController) },
            meetingsScreenDescription = { ScreenDescriptionMeeting(navController = navController) },
            communityScreen = { ScreenCommunity(navController = navController) },
            communityDetailsScreen = { ScreenDetailsCommunity(navController = navController) },
            myMoreScreen = { ScreenInfo(navController = navController) },
            myProfileScreen = { ScreenProfile(navController = navController) },
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
