package com.example.wbtechnoschool.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.events.CardCommunity
import com.example.wbtechnoschool.events.Community
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.search.AppSearchBar
import com.example.wbtechnoschool.utils.MagicNumbers

@Composable
fun ScreenCommunity(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = "Сообщества",
            )
        }, content = { innerPadding ->
            AppSearchBar(
                modifier = Modifier
                    .padding(horizontal = MagicNumbers.SCREEN_COMMUNITY_SEARCH_BAR_PADDING_HORIZONTAL.dp)
                    .padding(top = MagicNumbers.SCREEN_COMMUNITY_SEARCH_BAR_PADDING_TOP.dp)
                    .padding(innerPadding)
                    .fillMaxWidth()
                    .height(MagicNumbers.SCREEN_COMMUNITY_SEARCH_BAR_HEIGHT.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = MagicNumbers.SCREEN_COMMUNITY_LAZY_PADDING_HORIZONTAL.dp)
                    .padding(innerPadding)
                    .padding(top = MagicNumbers.SCREEN_COMMUNITY_LAZY_PADDING_TOP.dp)
                    .navigationBarsPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(count = 18 /*для примера*/) {
                    CardCommunity(
                        onClick = { navController.navigate(Graph.screenDetailsCommunity) },
                        community = Community(
                            icon = R.drawable.avatar_meeting,
                            title = "Designa", /*для примера*/
                            countPersons = "10 000 человек" /*для примера*/
                        ),
                        modifier = Modifier.padding(vertical = MagicNumbers.SCREEN_COMMUNITY_LAZY_CARD_COMMUNITY_PADDING_VERTICAL.dp)
                    )
                }
            }
        }
    )
}
