package com.example.wbtechnoschool.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme

@Composable
fun BottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        elevation = 5.dp,
        backgroundColor = LightColorTheme.neutralWhite,
    ) {

        Element.listOfNavItems.forEach { item ->
            val selected = item.route == navBackStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (selected) {
                            Text(text = item.description)
                            Icon(painterResource(id = R.drawable.icon_point_selected), contentDescription = "выбранный элемент", modifier = Modifier.padding(top = 5.dp))
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


