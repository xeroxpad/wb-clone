package com.example.wbtechnoschool.screens.auth

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.button.GradientButton
import com.example.wbtechnoschool.utils.search.FixTextField
import com.example.wbtechnoschool.viewmodel.auth_view_model.AuthorizationProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenMakeAnAppointment(
    modifier: Modifier = Modifier,
    viewModel: AuthorizationProfileViewModel = koinViewModel(),
    navController: NavController
) {
    val name by viewModel.name.collectAsState()
    LaunchedEffect(name) {
        viewModel.nameChange(name)
    }
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
                                    text = stringResource(id = R.string.log_in_and_make_an_appointment),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 49.sp,
                                    color = LightColorTheme.black,
                                    lineHeight = 40.sp
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = "Супертестировщики · 12 августа · Невский проспект, 11",
                                    fontWeight = FontWeight.W400,
                                    fontSize = 16.sp,
                                    color = LightColorTheme.black,
                                )
                            }
                            IconButton(
                                onClick = { },
                                modifier = Modifier
                                    .size(28.dp)
                                    .align(Alignment.Top)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_close),
                                    contentDescription = "Закрыть",
                                    tint = Color.Gray
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        FixTextField(placeholder = R.string.name_and_second_name, text = name, textChange = { viewModel.nameChange(it) })
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 15.dp)
                ) {
                    GradientButton(
                        modifier = Modifier.height(56.dp),
                        enable = name.isNotEmpty(),
                        textButton = "Продолжить",
                    ) {navController.navigate(Graph.EnteringNumberForAppointment.route)}
                }
            }
        }
    )
}