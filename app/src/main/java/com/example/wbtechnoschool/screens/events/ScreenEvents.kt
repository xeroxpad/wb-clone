package com.example.wbtechnoschool.screens.events

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.domain.entities.FixEvent
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.events.FixCardCommunity
import com.example.wbtechnoschool.utils.events.FixCardCommunityMini
import com.example.wbtechnoschool.utils.search.FixSearchTextField
import com.example.wbtechnoschool.viewmodel.community_view_model.CommunityViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenEvents(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MeetingViewModel = koinViewModel()
) {
    val events by viewModel.meetings.collectAsState()
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
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
            ) {
                item {
                    LazyRow {
                        items(events) { event ->
                            FixCardCommunity(
                                event = event,
                                onClick = {},
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = stringResource(id = R.string.upcoming_meetings),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W600,
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    LazyRow {
                        items(events) { event ->
                            FixCardCommunityMini(
                                event = event,
                                onClick = {},
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Сообщества для тестировщиков",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W600,
                        modifier = Modifier.padding(end = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    )
}