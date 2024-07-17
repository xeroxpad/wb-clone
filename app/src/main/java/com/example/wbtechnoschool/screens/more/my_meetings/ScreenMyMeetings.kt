package com.example.wbtechnoschool.screens.more.my_meetings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.screens.meetings.MyPastMeetings
import com.example.wbtechnoschool.screens.meetings.MyPlannedMeetings
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.MagicNumbers
import com.example.wbtechnoschool.viewmodel.more_view_model.my_meetings_view_model.MyMeetingsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenMyMeetings(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MyMeetingsViewModel = koinViewModel(),
) {
    val tabIndex by viewModel.tabIndex.collectAsState()
    val tabs = viewModel.getTabs().map { stringResource(id = it) }
    Scaffold(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = stringResource(id = R.string.top_bar_my_meetings),
                iconBack = { navController.popBackStack() },
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(horizontal = MagicNumbers.SCREEN_MY_MEETING_PADDING_HORIZONTAL.dp)
                    .navigationBarsPadding()
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                TabRow(selectedTabIndex = tabIndex, modifier = Modifier.fillMaxWidth()) {
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
                            selected = tabIndex == index,
                            onClick = { viewModel.setTabIndex(index) },
                            selectedContentColor = LightColorTheme.brandColorDefault,
                            unselectedContentColor = LightColorTheme.accentGrey
                        )
                    }
                }
                when (tabIndex) {
                    0 -> MyPlannedMeetings(navController)
                    1 -> MyPastMeetings(navController)
                }
            }
        }
    )
}