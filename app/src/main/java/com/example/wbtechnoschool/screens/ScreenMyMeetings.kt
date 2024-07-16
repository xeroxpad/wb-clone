package com.example.wbtechnoschool.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun ScreenMyMeetings(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = "Мои встречи",
                iconBack = {navController.popBackStack()},
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                var tabIndex by remember { mutableStateOf(0) }
                val tabs = listOf("ЗАПЛАНИРОВАНО", "УЖЕ ПРОШЛИ")
                TabRow(selectedTabIndex = tabIndex, modifier = Modifier.fillMaxWidth()) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = {
                                Text(
                                    title,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W500,
                                    fontFamily = fontSFPro
                                )
                            },
                            selected = tabIndex == index,
                            onClick = { tabIndex = index },
                            selectedContentColor = LightColorTheme.brandColorDefault,
                            unselectedContentColor = LightColorTheme.accentGrey
                        )
                    }
                }
                when (tabIndex) {
                    0 -> MyPlannedMeetings(navController)
                    1 -> MyPastMeetings(navController)
                }
            }
        }
    )
}