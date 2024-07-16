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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.AddAvatarProfile
import com.example.wbtechnoschool.button.StatusButton
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.search.CustomTextFieldForProfile
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.MagicNumbers
import com.example.wbtechnoschool.utils.SPACER

@Composable
fun ScreenAuthorizationProfile(navController: NavController, modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    Scaffold(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = stringResource(id = R.string.top_bar_profile),
                iconBack = { navController.popBackStack() },
                actions = null,
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(horizontal = MagicNumbers.SCREEN_AUTH_PROF_COLUMN_PADDING_HORIZONTAL.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(SPACER.SPACER_60.value.dp))
                AddAvatarProfile()
                Spacer(modifier = Modifier.height(SPACER.SPACER_30.value.dp))
                CustomTextFieldForProfile(
                    textPlaceholder = stringResource(id = R.string.text_placeholder_name),
                    text = name,
                    textChange = { name = it }
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                CustomTextFieldForProfile(
                    textPlaceholder = stringResource(id = R.string.text_placeholder_surname),
                    text = surname,
                    textChange = { surname = it }
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_40.value.dp))
                StatusButton(
                    containerColor = LightColorTheme.brandColorDefault,
                    enable = name.isNotEmpty(),
                    onClick = { navController.navigate("${Graph.screenSplashHelloName}/$name") }, // пока для показа тут пример перехода
                    contentText = stringResource(id = R.string.save),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MagicNumbers.SCREEN_AUTH_PROF_STATUS_BUTTON_HEIGHT.dp)
                )
            }
        }
    )
}