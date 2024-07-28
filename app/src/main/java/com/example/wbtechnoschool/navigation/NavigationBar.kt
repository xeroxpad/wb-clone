package com.example.wbtechnoschool.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
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
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.widgets.NoRippleInteractionSource

@Composable
fun BottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    val noRippleInteractionSource = remember { NoRippleInteractionSource() }
    BottomNavigation(
        modifier = modifier,
        elevation = MagicNumbers.BOTTOM_NAV_BAR_ELEVATION.dp,
        backgroundColor = LightColorTheme.neutralWhite,
    ) {
        listRootElement.forEach { item ->
            val selected = currentRoute?.hierarchy?.any { it.route == item.route } == true
            BottomNavigationItem(
                selected = selected,
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
                        when {
                            selected -> {
                                Text(
                                    text = item.description,
                                    fontWeight = FontWeight.W600,
                                    fontFamily = fontSFPro,
                                    color = LightColorTheme.neutralActive
                                )
                                Icon(
                                    painterResource(id = R.drawable.icon_point_selected),
                                    contentDescription = null,
                                    modifier = Modifier.padding(top = MagicNumbers.BOTTOM_NAV_COLUMN_ICON_PADDING_TOP.dp)
                                )
                            }
                            else -> {
                                Image(
                                    painterResource(id = item.icon!!),
                                    contentDescription = item.description,
                                    modifier = Modifier.padding(top = MagicNumbers.BOTTOM_NAV_COLUMN_IMAGE_PADDING_TOP.dp),
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}






