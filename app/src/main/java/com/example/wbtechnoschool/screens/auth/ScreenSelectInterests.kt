package com.example.wbtechnoschool.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.screens.meetings.SelectOtherMeetings
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.button.GradientButtonDark
import com.example.wbtechnoschool.utils.button.StatusTextButton

@Composable
fun ScreenSelectInterests(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val selectedTags by remember { mutableStateOf(setOf<String>()) }
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {},
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                LazyColumn(
                    modifier = modifier
                        .padding(20.dp)
                ) {
                    item {
                        Text(
                            text = "Интересы",
                            fontWeight = FontWeight.W600,
                            fontSize = 49.sp,
                            color = LightColorTheme.black,
                        )
                        Text(
                            text = "Выберите интересы, чтобы мы рекомендовали полезные встречи",
                            fontWeight = FontWeight.W400,
                            fontSize = 19.sp,
                            color = LightColorTheme.black,
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        SelectOtherMeetings()
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 15.dp)
                ) {
                    GradientButtonDark(
                        modifier = Modifier.height(49.dp),
                        enable = selectedTags.isNotEmpty(),
                        textButton = "Сохранить",
                        onClick = {navController.navigate(Graph.GeoData.route)}
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    StatusTextButton(
                        contentColor = LightColorTheme.indigoTwilight,
                        containerColor = Color.Transparent,
                        enable = true,
                        onClick = { navController.navigate(Graph.Events.route) },
                        contentText = stringResource(id = R.string.tell_you_later)
                    )
                }
            }
        }
    )
}