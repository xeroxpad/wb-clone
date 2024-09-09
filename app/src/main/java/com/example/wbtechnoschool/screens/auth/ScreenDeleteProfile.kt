package com.example.wbtechnoschool.screens.auth

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.button.GradientButtonDark
import com.example.wbtechnoschool.utils.button.GradientButtonLight

@Composable
fun ScreenDeleteProfile(modifier: Modifier = Modifier, navController: NavController) {
    val focusManager = LocalFocusManager.current
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            },
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
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(5f)
                                    .padding(top = 0.dp),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = stringResource(id = R.string.sure_you_want_delete_profile),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 49.sp,
                                    color = LightColorTheme.black,
                                    lineHeight = 40.sp
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = stringResource(id = R.string.dont_were_cool),
                                    fontWeight = FontWeight.W400,
                                    fontSize = 16.sp,
                                    color = LightColorTheme.black,
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                            }
                            IconButton(
                                onClick = { navController.popBackStack() },
                                modifier = Modifier
                                    .weight(1f)
                                    .size(48.dp)
                                    .align(Alignment.Top)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_close),
                                    contentDescription = null,
                                    tint = Color.Gray
                                )
                            }
                        }
                        Text(
                            text = stringResource(id = R.string.we_will_delete_profile_30_days),
                            fontWeight = FontWeight.W400,
                            fontSize = 16.sp,
                            color = LightColorTheme.black,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 15.dp)
                ) {
                    GradientButtonLight(
                        modifier = Modifier.height(56.dp),
                        enable = true,
                        textButton = "Удалить",
                    ) { }
                    Spacer(modifier = Modifier.height(10.dp))
                    GradientButtonDark(
                        modifier = Modifier.height(56.dp),
                        enable = true,
                        textButton = "Не надо",
                    ) { navController.navigate(Graph.Profile.route) }
                }
            }
        }
    )
}