package com.example.wbtechnoschool.screens.meetings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER
import com.example.wbtechnoschool.utils.search.AppSearchBar
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingsTab
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenMeeting(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MeetingViewModel = koinViewModel()
) {
    val tabIndex by viewModel.tabIndex.collectAsState()
    val tabs = viewModel.getTabs().map { stringResource(id = it) }
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = stringResource(id = R.string.top_bar_meetings),
                actionsIcon = R.drawable.icon_add
            )
        },
        content = { innerPadding ->
            Column(
                modifier =
                Modifier
                    .padding(innerPadding)
                    .padding(horizontal = MagicNumbers.SCREEN_MEETING_PADDING_HORIZONTAL.dp)
                    .padding(top = MagicNumbers.SCREEN_MEETING_PADDING_TOP.dp)
                    .navigationBarsPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppSearchBar(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(MagicNumbers.SCREEN_MEETING_APP_SEARCH_BAR_HEIGHT.dp)
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                TabRow(selectedTabIndex = tabIndex.ordinal, modifier = Modifier.fillMaxWidth()) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = {
                                Text(
                                    title,
                                    fontSize = MagicNumbers.SCREEN_MY_MEETING_TAB_ROW_TEXT_FOT_SIZE.sp,
                                    fontWeight = FontWeight.W500,
                                    fontFamily = fontSFPro
                                )
                            },
                            selected = tabIndex.ordinal == index,
                            onClick = { viewModel.setTabIndex(MeetingsTab.entries[index]) },
                            selectedContentColor = LightColorTheme.brandColorDefault,
                            unselectedContentColor = LightColorTheme.accentGrey
                        )
                    }
                }
                when (tabIndex) {
                    MeetingsTab.ALL_MEETINGS -> AllMeetings(navController)
                    MeetingsTab.ACTIVE_MEETINGS -> ActiveMeetings(navController)
                }
            }
        }
    )
}
