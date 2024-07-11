package com.example.wbtechnoschool.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.RowAvatars
import com.example.wbtechnoschool.chips.FilterChips
import com.example.wbtechnoschool.features.ShowImage
import com.example.wbtechnoschool.features.ToggleButton
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum

@Composable
fun ScreenDescriptionMeeting(navController: NavController) {
    var isGoing by remember { mutableStateOf(true) }
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = "Developer meeting",
                iconBack = { navController.popBackStack() },
                actions = { },
                actionsIcon = if (!isGoing) R.drawable.icon_bird else null,
                actionsTint = LightColorTheme.brandColorDefault
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .navigationBarsPadding()
                    .padding(innerPadding)
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            ) {
                var showMoreText by remember { mutableStateOf(false) }
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .animateContentSize(animationSpec = tween(100))
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { showMoreText = !showMoreText },
                    verticalArrangement = Arrangement.Top,
                ) {
                    item(1) {
                        Row(
                            modifier = Modifier
                                .padding(top = 20.dp)
                        ) {
                            val dateMeeting = "13.09.2024"
                            val locationMeeting = "Москва, ул. Громова, 4"
                            val allTextMeeting = ("$dateMeeting - $locationMeeting")
                            Text(
                                text = allTextMeeting,
                                fontFamily = fontSFPro,
                                fontWeight = FontWeight.W600,
                                fontSize = 14.sp,
                                color = LightColorTheme.neutralWeak
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(bottom = 5.dp)
                        ) {
                            FilterChips(labelText = "Kotlin")
                            FilterChips(labelText = "Junior")
                            FilterChips(labelText = "Moscow")
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        ShowImage(R.drawable.map)
                        Spacer(modifier = Modifier.height(15.dp))
                        val lorem: Lorem = LoremIpsum()
                        val loremText = lorem.getWords(200)
                        if (showMoreText) {
                            Text(
                                text = loremText,
                                fontSize = 12.sp,
                                fontFamily = fontSFPro,
                                fontWeight = FontWeight.W400,
                                color = LightColorTheme.neutralWeak
                            )
                        } else {
                            Text(
                                text = loremText,
                                fontSize = 12.sp,
                                fontFamily = fontSFPro,
                                fontWeight = FontWeight.W400,
                                color = LightColorTheme.neutralWeak,
                                maxLines = 8,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        RowAvatars()
                        Spacer(
                            Modifier.windowInsetsBottomHeight(
                                WindowInsets.systemBars
                            )
                        )
                    }
                }
                ToggleButton(
                    isSelected = { selected ->
                        isGoing = selected
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )
            }
        }
    )
}

