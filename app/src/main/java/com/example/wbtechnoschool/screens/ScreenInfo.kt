package com.example.wbtechnoschool.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.MyMainAvatar
import com.example.wbtechnoschool.features.ContainerToGo
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.MagicNumbers
import com.example.wbtechnoschool.utils.SPACER

@Composable
fun ScreenInfo(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = stringResource(id = R.string.top_bar_screen_info)
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(horizontal = MagicNumbers.SCREEN_INFO_COLUMN_PADDING_HORIZONTAL.dp)
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(MagicNumbers.SCREEN_INFO_ROW_CLIP.dp))
                        .clickable { navController.navigate(Graph.screenProfile) },
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    MyMainAvatar(
                        painter = painterResource(id = R.drawable.avatars),
                        contentDescription = null,
                        modifier = Modifier
                            .size(MagicNumbers.SCREEN_INFO_MY_MAIN_AVATAR_SIZE.dp)
                            .clip((CircleShape))
                    )
                    Spacer(modifier = Modifier.width(SPACER.SPACER_20.value.dp))
                    Column(modifier = Modifier.weight(MagicNumbers.SCREEN_INFO_COLUMN_WEIGHT)) {
                        Text(
                            text = stringResource(id = R.string.profile_name), /*для примера*/
                            fontSize = MagicNumbers.SCREEN_INFO_COLUMN_TEXT_NAME_FONT_SIZE.sp,
                            fontFamily = fontSFPro,
                            fontWeight = FontWeight.W600,
                        )
                        Text(
                            text = stringResource(id = R.string.profile_number), /*для примера*/
                            fontSize = MagicNumbers.SCREEN_INFO_COLUMN_TEXT_NUMBER_FONT_SIZE.sp,
                            fontFamily = fontSFPro,
                            fontWeight = FontWeight.W400,
                            color = LightColorTheme.neutralDisabled,
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.icon_go),
                        contentDescription = null,
                        modifier = Modifier.size(MagicNumbers.SCREEN_INFO_ICON_GO_SIZE.dp)
                    )
                }
                Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                ContainerToGo(
                    icon = R.drawable.meeting,
                    title = stringResource(id = R.string.container_to_go_title_my_meetings),
                    onClick = { navController.navigate(Graph.screenMyMeetings) }
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                ContainerToGo(
                    icon = R.drawable.icon_theme,
                    title = stringResource(id = R.string.container_to_go_title_theme),
                    onClick = { navController.navigate(Graph.screenTheme) }
                )
                ContainerToGo(
                    icon = R.drawable.icon_notifications,
                    title = stringResource(id = R.string.container_to_go_title_notifications),
                    onClick = { navController.navigate(Graph.screenNotifications) }
                )
                ContainerToGo(
                    icon = R.drawable.icon_safety,
                    title = stringResource(id = R.string.container_to_go_title_safety),
                    onClick = { navController.navigate(Graph.screenSafety) }
                )
                ContainerToGo(
                    icon = R.drawable.icon_recources,
                    title = stringResource(id = R.string.container_to_go_title_resources),
                    onClick = { navController.navigate(Graph.screenResources) }
                )
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = MagicNumbers.SCREEN_INFO_HORIZONTAL_DIVIDER_VERTICAL_PADDING.dp),
                    color = LightColorTheme.neutralLine
                )
                ContainerToGo(
                    icon = R.drawable.icon_help,
                    title = stringResource(id = R.string.container_to_go_title_help),
                    onClick = { navController.navigate(Graph.screenHelp) },
                    sizeIcon = MagicNumbers.SCREEN_INFO_ICON_HELP_SIZE.dp,
                    paddingIcon = MagicNumbers.SCREEN_INFO_ICON_HELP_PADDING.dp
                )
                ContainerToGo(
                    icon = R.drawable.icon_invite_friend,
                    title = stringResource(id = R.string.container_to_go_title_invite_friend),
                    onClick = { navController.navigate(Graph.inviteFriend) }
                )
            }
        }
    )
}