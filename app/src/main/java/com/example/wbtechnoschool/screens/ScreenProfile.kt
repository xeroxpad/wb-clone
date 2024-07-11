package com.example.wbtechnoschool.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.MyMainAvatar
import com.example.wbtechnoschool.button.IconOutlinedButton
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun ScreenProfile(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = "Профиль",
                iconBack = { navController.popBackStack() },
                actions = { navController.navigate(Graph.screenAuthorizationProfile) },
                actionsIcon = R.drawable.edit
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                Spacer(modifier = Modifier.height(80.dp))
                MyMainAvatar(
                    painter = painterResource(id = R.drawable.avatars),
                    contentDescription = "",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip((CircleShape))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Михаил Никонов",
                    fontSize = 24.sp,
                    fontFamily = fontSFPro,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "+7 999 999-99-99",
                    fontSize = 16.sp,
                    fontFamily = fontSFPro,
                    fontWeight = FontWeight.W400,
                    color = LightColorTheme.neutralDisabled,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconOutlinedButton(
                        contentColor = LightColorTheme.brandColorDefault,
                        onClick = { /*TODO*/ },
                        icon = (R.drawable.icon_twitter)
                    )
                    IconOutlinedButton(
                        contentColor = LightColorTheme.brandColorDefault,
                        onClick = { /*TODO*/ },
                        icon = (R.drawable.icon_inst)
                    )
                    IconOutlinedButton(
                        contentColor = LightColorTheme.brandColorDefault,
                        onClick = { /*TODO*/ },
                        icon = (R.drawable.icon_linkedin)
                    )
                    IconOutlinedButton(
                        contentColor = LightColorTheme.brandColorDefault,
                        onClick = { /*TODO*/ },
                        icon = (R.drawable.icon_meta)
                    )
                }
            }
        }
    )
}