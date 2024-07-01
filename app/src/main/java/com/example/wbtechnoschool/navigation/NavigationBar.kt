package com.example.wbtechnoschool.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbtechnoschool.ui.theme.LightColorTheme

@Composable
fun BottomNavBar(
    navController: NavHostController,
    interactionSource: MutableInteractionSource? = null
) {
    BottomNavigation(backgroundColor = LightColorTheme.neutralWhite) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Element.listOfNavItems.forEach { navItem ->
            BottomNavigationItem(
                interactionSource = interactionSource,
                selected = currentRoute == navItem.route,
                onClick = { navController.navigate(navItem.route) {launchSingleTop} },
                icon = {
                    Image(
                        painterResource(id = navItem.icon),
                        contentDescription = navItem.description,
                        modifier = Modifier.padding(top = 15.dp),
                    )
                },
                label = { Text(text = navItem.description) }
            )
        }
    }
}



