package com.example.wbtechnoschool.screens.events

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.domain.entities.FixEvent
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.events.FixCardCommunity
import com.example.wbtechnoschool.utils.search.FixSearchTextField

@Composable
fun ScreenEvents(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize(),
        content = { innerPadding ->
            Row(modifier = Modifier.padding(horizontal = 20.dp)) {
                FixSearchTextField(
                    placeholder = R.string.search_meetings_and_community,
                    modifier = Modifier
                        .weight(1f),
                )
            }
            LazyColumn(
                modifier =
                Modifier
                    .padding(start = 20.dp)
                    .padding(innerPadding)
                    .padding(top = MagicNumbers.SCREEN_COMMUNITY_LAZY_PADDING_TOP.dp)
                    .navigationBarsPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    FixCardCommunity(
                        event = FixEvent(
                            1,
                            "https://digital.gov.ru/uploaded/photos/l52a2533.JPG",
                            "QA Talks — Global tech forum"
                        ), onClick = {})
                }
            }
        }
    )
}