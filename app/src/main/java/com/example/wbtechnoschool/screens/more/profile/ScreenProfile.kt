package com.example.wbtechnoschool.screens.more.profile

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.avatar.MyMainAvatar
import com.example.wbtechnoschool.utils.button.IconOutlinedButton
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER
import com.example.wbtechnoschool.viewmodel.more_view_model.profile_view_model.ProfileViewModule
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenProfile(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ProfileViewModule = koinViewModel()
) {
    val name by viewModel.name.collectAsState()
    val phoneNumber by viewModel.phoneNumber.collectAsState()
    val socialMediaIcons by viewModel.socialMediaIcons.collectAsState()
    val avatarUrl = viewModel.avatar.collectAsState()
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = stringResource(id = R.string.top_bar_my_profile),
                iconBack = { navController.popBackStack() },
                actions = { navController.navigate(Graph.AuthorizationProfile.route) },
                actionsIcon = R.drawable.edit
            )
        },
        content = { innerPadding ->
            Column(
                modifier =
                Modifier
                    .padding(MagicNumbers.SCREEN_PROFILE_PADDING_HORIZONTAL.dp)
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(SPACER.SPACER_80.value.dp))
                MyMainAvatar(
                    model = avatarUrl.value,
                    contentDescription = null,
                    modifier =
                    Modifier
                        .size(MagicNumbers.SCREEN_PROFILE_MY_MAIN_AVATAR_SIZE.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip((CircleShape))
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                Text(
                    text = name,
                    fontSize = MagicNumbers.SCREEN_PROFILE_TEXT_NAME_FONT_SIZE.sp,
                    fontFamily = fontSFPro,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = phoneNumber,
                    fontSize = MagicNumbers.SCREEN_PROFILE_TEXT_NUMBER_FONT_SIZE.sp,
                    fontFamily = fontSFPro,
                    fontWeight = FontWeight.W400,
                    color = LightColorTheme.neutralDisabled,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    socialMediaIcons.forEach { icon ->
                        IconOutlinedButton(
                            contentColor = LightColorTheme.brandColorDefault,
                            onClick = { },
                            icon = icon
                        )
                    }
                }
            }
        }
    )
}
