package com.example.wbtechnoschool.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbtechnoschool.avatar.AddAvatarProfile
import com.example.wbtechnoschool.button.StatusButton
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.search.CustomTextFieldForProfile
import com.example.wbtechnoschool.ui.theme.LightColorTheme

@Composable
fun ScreenAuthorizationProfile(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = "Профиль",
                iconBack = { navController.popBackStack() },
                actions = null,
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var name by rememberSaveable { mutableStateOf("") }
                var surname by rememberSaveable { mutableStateOf("") }
                Spacer(modifier = Modifier.height(60.dp))
                AddAvatarProfile()
                Spacer(modifier = Modifier.height(30.dp))
                CustomTextFieldForProfile(
                    textPlaceholder = "Имя (обязательно)",
                    text = name,
                    textChange = {name = it}
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextFieldForProfile(
                    textPlaceholder = "Фамилия (опционально)",
                    text = surname,
                    textChange = {surname = it}
                )
                Spacer(modifier = Modifier.height(40.dp))
                StatusButton(
                    containerColor = LightColorTheme.brandColorDefault,
                    enable = name.isNotEmpty(),
                    onClick = { navController.navigate("${Graph.screenSplashHelloName}/$name") }, // пока для показа тут пример перехода
                    contentText = "Сохранить",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(53.dp)
                )
            }
        }
    )
}