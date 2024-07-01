package com.example.wbtechnoschool.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.MyMainAvatar
import com.example.wbtechnoschool.features.ContainerToGo
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenInfo() {

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Еще",
                        modifier = Modifier.offset(x = (-13).dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W600
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {},
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    MyMainAvatar(
                        painter = painterResource(id = R.drawable.avatar_main),
                        contentDescription = "аватар профиль",
                        modifier = Modifier
                            .size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Column(modifier = Modifier.weight(1.8f)) {
                        Text(
                            text = "Иван Иванов",
                            fontSize = 18.sp,
                            fontFamily = fontSFPro,
                            fontWeight = FontWeight.W600,
                        )
                        Text(
                            text = "+7 999 999-99-99",
                            fontSize = 14.sp,
                            fontFamily = fontSFPro,
                            fontWeight = FontWeight.W400,
                            color = LightColorTheme.neutralDisabled,
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.icon_go),
                        contentDescription = "Перейти",
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                ContainerToGo(
                    icon = R.drawable.meeting,
                    title = "Мои встречи",
                )
                Spacer(modifier = Modifier.height(20.dp))
                ContainerToGo(
                    icon = R.drawable.icon_theme,
                    title = "Тема",
                )
                ContainerToGo(
                    icon = R.drawable.icon_notifications,
                    title = "Уведомления",
                )
                ContainerToGo(
                    icon = R.drawable.icon_safety,
                    title = "Безопасность",
                )
                ContainerToGo(
                    icon = R.drawable.icon_recources,
                    title = "Память и ресурсы",
                )
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = LightColorTheme.neutralLine
                )
                ContainerToGo(
                    icon = R.drawable.icon_help,
                    title = "Помощь",
                )
                ContainerToGo(
                    icon = R.drawable.icon_invite_friend,
                    title = "Пригласи друга",
                )
            }
        }
    )
}