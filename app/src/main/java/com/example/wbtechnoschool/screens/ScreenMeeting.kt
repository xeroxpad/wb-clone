package com.example.wbtechnoschool.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.features.SwitchRow
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.search.AppSearchBar

@Composable
fun ScreenMeeting(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = "Встречи",
                actions = {},
                actionsIcon = R.drawable.icon_add
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                    .navigationBarsPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AppSearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                SwitchRow(listOf("ВСЕ ВСТРЕЧИ", "АКТИВНЫЕ"), navController)
            }
        },
    )
}




