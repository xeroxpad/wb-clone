package com.example.wbtechnoschool.screens.meetings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.wbtechnoschool.utils.avatar.RowAvatars
import com.example.wbtechnoschool.utils.chips.FilterChips
import com.example.wbtechnoschool.utils.widgets.ShowImage
import com.example.wbtechnoschool.utils.widgets.ToggleButton
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER
import com.example.wbtechnoschool.viewmodel.meetings_view_model.DescriptionMeetingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenDescriptionMeeting(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: DescriptionMeetingViewModel = koinViewModel(),
) {
    val showMoreText by viewModel.showMoreText.collectAsState()
    val loremText by viewModel.loremText.collectAsState()
    val isGoing by viewModel.isGoing.collectAsState()
    Scaffold(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = stringResource(id = R.string.top_bar_description_meeting),
                iconBack = { navController.popBackStack() },
                actions = {},
                actionsIcon = when {
                    !isGoing -> R.drawable.icon_bird
                    else -> null
                },
                actionsTint = LightColorTheme.brandColorDefault
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .navigationBarsPadding()
                    .padding(innerPadding)
                    .padding(
                        start = MagicNumbers.SCREEN_DESCRIPTION_MEETING_CONTENT_COLUMN_PADDING_START.dp,
                        end = MagicNumbers.SCREEN_DESCRIPTION_MEETING_CONTENT_COLUMN_PADDING_END.dp,
                        bottom = MagicNumbers.SCREEN_DESCRIPTION_MEETING_CONTENT_COLUMN_PADDING_BOTTOM.dp
                    ),
            ) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { viewModel.toggleShowMoreText() },
                    verticalArrangement = Arrangement.Top,
                ) {
                    item(1) {
                        Row(
                            modifier = Modifier
                                .padding(top = MagicNumbers.SCREEN_DESCRIPTION_ROW_PADDING_TOP.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.date_and_location_meeting),
                                fontFamily = fontSFPro,
                                fontWeight = FontWeight.W600,
                                fontSize = MagicNumbers.SCREEN_DESCRIPTION_ROW_TEXT_FONT_SIZE.sp,
                                color = LightColorTheme.neutralWeak
                            )
                        }
                        Row() {
                            FilterChips(labelText = "Kotlin")
                            FilterChips(labelText = "Junior")
                            FilterChips(labelText = "Moscow")
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                        ShowImage(image = R.drawable.map)
                        Spacer(modifier = Modifier.height(SPACER.SPACER_15.value.dp))
                        when {
                            showMoreText -> {
                                Text(
                                    text = loremText,
                                    fontSize = MagicNumbers.SCREEN_DESCRIPTION_SHOW_MORE_TEXT_FONT_SIZE.sp,
                                    fontFamily = fontSFPro,
                                    fontWeight = FontWeight.W400,
                                    color = LightColorTheme.neutralWeak
                                )
                            }
                            else -> {
                                Text(
                                    text = loremText,
                                    fontSize = MagicNumbers.SCREEN_DESCRIPTION_SHOW_MORE_TEXT_FONT_SIZE.sp,
                                    fontFamily = fontSFPro,
                                    fontWeight = FontWeight.W400,
                                    color = LightColorTheme.neutralWeak,
                                    maxLines = MagicNumbers.SCREEN_DESCRIPTION_SHOW_MORE_MAX_LINES,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(SPACER.SPACER_15.value.dp))
                        RowAvatars()
                        Spacer(
                            Modifier.windowInsetsBottomHeight(
                                WindowInsets.systemBars
                            )
                        )
                    }
                }
                ToggleButton(
                    isSelected = { selected ->
                        viewModel.toggleIsGoing()
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .height(MagicNumbers.SCREEN_DESCRIPTION_TOGGLE_BUTTON_HEIGHT.dp)
                )
            }
        }
    )
}

