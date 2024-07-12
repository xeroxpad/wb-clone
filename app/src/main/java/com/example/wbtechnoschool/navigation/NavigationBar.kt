package com.example.wbtechnoschool.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.features.NoRippleInteractionSource
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun BottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    BottomNavigation(
        modifier = modifier,
        elevation = 5.dp,
        backgroundColor = LightColorTheme.neutralWhite,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Element.listOfNavItems.forEach { item ->
            val isSelected = when (item) {
                Element.listOfNavItems[2] -> currentRoute == item.route ||
                        currentRoute == Graph.screenProfile ||
                        currentRoute == Graph.screenMyMeetings ||
                        currentRoute == Graph.screenTheme ||
                        currentRoute == Graph.screenNotifications ||
                        currentRoute == Graph.screenSafety ||
                        currentRoute == Graph.screenResources ||
                        currentRoute == Graph.screenHelp ||
                        currentRoute == Graph.inviteFriend

                Element.listOfNavItems[1] -> currentRoute == item.route ||
                        currentRoute == Graph.screenDetailsCommunity

                Element.listOfNavItems[0] -> currentRoute == item.route ||
                        currentRoute == Graph.screenDescriptionMeeting

                else -> currentRoute == item.route
            }
            val noRippleInteractionSource = remember { NoRippleInteractionSource() }
            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                interactionSource = noRippleInteractionSource,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (isSelected) {
                            Text(
                                text = item.description,
                                fontWeight = FontWeight.W600,
                                fontFamily = fontSFPro,
                                color = LightColorTheme.neutralActive
                            )
                            Icon(
                                painterResource(id = R.drawable.icon_point_selected),
                                contentDescription = "выбранный элемент",
                                modifier = Modifier.padding(top = 5.dp)
                            )
                        } else {
                            Image(
                                painterResource(id = item.icon),
                                contentDescription = item.description,
                                modifier = Modifier.padding(top = 15.dp),
                            )
                        }
                    }
                }
            )
        }
    }
}




