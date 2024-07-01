package com.example.wbtechnoschool.screens

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.MyMainAvatar
import com.example.wbtechnoschool.button.IconOutlinedButton
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenProfile() {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Профиль",
                        modifier = Modifier.offset(x = (-13).dp),
                        fontSize = 24.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "вернуться",
                            modifier = Modifier
                                .size(20.dp)
                                .offset(x = -(15).dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.edit),
                            contentDescription = "редактировать",
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
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
                Spacer(modifier = Modifier.height(80.dp))
                MyMainAvatar(
                    painter = painterResource(id = R.drawable.avatar_main),
                    contentDescription = "аватар профиль",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally),
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Иван Иванов",
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

@Preview(showBackground = true)
@Composable
fun PrevScreenProfile() {
    ScreenProfile()
}