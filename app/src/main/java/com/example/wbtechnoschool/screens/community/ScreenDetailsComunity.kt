package com.example.wbtechnoschool.screens.community

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.utils.events.CardActiveMeetings
import com.example.wbtechnoschool.utils.events.CardCompletedMeetings
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER
import com.example.wbtechnoschool.viewmodel.community_view_model.DetailsCommunityViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenDetailsCommunity(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DetailsCommunityViewModel = koinViewModel(),
) {
    val showMoreText by viewModel.showMoreText.collectAsState()
    val loremText by viewModel.loremText.collectAsState()
    val meetings by viewModel.meetings.collectAsState()
    Scaffold(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = stringResource(id = R.string.card_community_title),
                iconBack = { navController.popBackStack() },
            )
        }, content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = MagicNumbers.SCREEN_DETAILS_COMMUNITY_LAZY_PADDING_HORIZONTAL.dp)
                    .padding(innerPadding)
                    .navigationBarsPadding()
                    .fillMaxSize()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { viewModel.toggleShowMoreText() },
                verticalArrangement = Arrangement.Top,
            ) {
                item(1) {
                    when {
                        showMoreText -> {
                            Text(
                                text = loremText,
                                fontSize = MagicNumbers.SCREEN_DETAILS_COMMUNITY_LAZY_SHOW_TEXT_FONT_SIZE.sp,
                                fontFamily = fontSFPro,
                                fontWeight = FontWeight.W400,
                                color = LightColorTheme.neutralWeak
                            )
                        }

                        else -> {
                            Text(
                                text = loremText,
                                fontSize = MagicNumbers.SCREEN_DETAILS_COMMUNITY_LAZY_SHOW_TEXT_FONT_SIZE.sp,
                                fontFamily = fontSFPro,
                                fontWeight = FontWeight.W400,
                                color = LightColorTheme.neutralWeak,
                                maxLines = MagicNumbers.SCREEN_DETAILS_COMMUNITY_LAZY_SHOW_TEXT_MAX_LINES,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(SPACER.SPACER_30.value.dp))
                    Text(
                        text = stringResource(id = R.string.meetings_community),
                        fontSize = MagicNumbers.SCREEN_DETAILS_COMMUNITY_TEXT_MEETINGS_COMMUNITY_FONT_SIZE.sp,
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.W600,
                        color = LightColorTheme.neutralWeak
                    )
                    Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                }
                items(meetings) { meeting ->
                    CardActiveMeetings(
                        onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                        meetings = meeting,
                    )
                    CardCompletedMeetings(
                        onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                        meetings = meeting,
                    )
                }
            }
        }
    )
}