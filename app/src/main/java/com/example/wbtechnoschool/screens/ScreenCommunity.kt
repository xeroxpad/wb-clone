package com.example.wbtechnoschool.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.events.CardCommunity
import com.example.wbtechnoschool.events.Community
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.search.AppSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCommunity(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Сообщества",
                        modifier = Modifier.offset(x = (-13).dp),
                        fontSize = 24.sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
            )
        }, content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(top = 10.dp)
                    .navigationBarsPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item(1) {
                    AppSearchBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(bottom = 20.dp)
                    )
                }
                items(count = 18) {
                    CardCommunity(
                        onClick = { navController.navigate(Graph.screenDetailsCommunity) },
                        community = Community(
                            icon = R.drawable.avatar_meeting,
                            title = "Designa",
                            countPersons = "10 000 человек"
                        )
                    )
                }
            }
        }
    )
}
