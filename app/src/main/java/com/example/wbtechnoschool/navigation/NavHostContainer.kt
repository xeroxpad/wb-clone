package com.example.wbtechnoschool.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschool.screens.MyMeetings
import com.example.wbtechnoschool.screens.ScreenCommunity
import com.example.wbtechnoschool.screens.ScreenInfo
import com.example.wbtechnoschool.screens.ScreenMeeting
import com.example.wbtechnoschool.screens.ScreenProfile

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
            ScreenInfo()
        }
    }
}