package com.example.wbtechnoschool.screens

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbtechnoschool.navigation.BottomNavBar
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.NavHostContainer

@Composable
fun StartScreen(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val baseRoute = currentRoute?.substringBefore("/") ?: ""
    val showBottomBar = baseRoute != Graph.splashScreen &&
                baseRoute != Graph.screenAuthorization &&
                baseRoute != Graph.screenEntryCode &&
                baseRoute != Graph.screenAuthorizationProfile &&
                baseRoute != Graph.screenSplashHelloName
    Scaffold(bottomBar = {
        if (showBottomBar) {
            BottomNavBar(navController = navController, modifier = Modifier.navigationBarsPadding())
        }
    }) { innerPadding ->
        NavHostContainer(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}