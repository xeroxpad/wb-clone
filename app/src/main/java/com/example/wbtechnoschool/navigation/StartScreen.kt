package com.example.wbtechnoschool.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StartScreen(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val baseRoute = currentRoute?.substringBefore("/") ?: ""
    val bottomBarIsShow = rememberSaveable { (mutableStateOf(true)) }
    bottomBarIsShow.value =
        when (baseRoute) {
            Graph.Splash.route,
            Graph.Authorization.route,
            Graph.EntryCode.route,
            Graph.AuthorizationProfile.route,
            Graph.SplashHelloName.route,
            "",
            -> false
            else -> true
        }

    Scaffold { padding ->
        NavHostContainer(
            navController = navController,
            modifier = Modifier.padding(padding),
        )
    }
}
