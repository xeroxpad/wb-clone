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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.utils.widgets.SwitchRow
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.utils.search.AppSearchBar
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER

@Composable
fun ScreenMeeting(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Scaffold(
        modifier = modifier
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
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = MagicNumbers.SCREEN_MEETING_PADDING_HORIZONTAL.dp)
                    .padding(top = MagicNumbers.SCREEN_MEETING_PADDING_TOP.dp)
                    .navigationBarsPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AppSearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MagicNumbers.SCREEN_MEETING_APP_SEARCH_BAR_HEIGHT.dp)
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                SwitchRow(
                    titleRow = listOf(
                        stringResource(id = R.string.all_meetings),
                        stringResource(id = R.string.active_meetings)
                    ), navController = navController
                )
            }
        },
    )
}




