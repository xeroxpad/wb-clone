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
import com.example.wbtechnoschool.button.IconOutlinedButton
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.MagicNumbers
import com.example.wbtechnoschool.utils.SPACER

@Composable
fun ScreenProfile(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = stringResource(id = R.string.top_bar_my_profile),
                iconBack = { navController.popBackStack() },
                actions = { navController.navigate(Graph.screenAuthorizationProfile) },
                actionsIcon = R.drawable.edit
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(MagicNumbers.SCREEN_PROFILE_PADDING_HORIZONTAL.dp)
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                Spacer(modifier = Modifier.height(SPACER.SPACER_80.value.dp))
                MyMainAvatar(
                    painter = painterResource(id = R.drawable.avatars),
                    contentDescription = null,
                    modifier = Modifier
                        .size(MagicNumbers.SCREEN_PROFILE_MY_MAIN_AVATAR_SIZE.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip((CircleShape))
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_20.value.dp))
                Text(
                    text = "Михаил Никонов",
                    fontSize = MagicNumbers.SCREEN_PROFILE_TEXT_NAME_FONT_SIZE.sp,
                    fontFamily = fontSFPro,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "+7 999 999-99-99",
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
                    IconOutlinedButton(
                        contentColor = LightColorTheme.brandColorDefault,
                        onClick = { /*TODO*/ },
                        icon = (R.drawable.icon_twitter)
                    )
                    IconOutlinedButton(
                        contentColor = LightColorTheme.brandColorDefault,
                        onClick = { /*TODO*/ },
                        icon = (R.drawable.icon_inst)
                    )
                    IconOutlinedButton(
                        contentColor = LightColorTheme.brandColorDefault,
                        onClick = { /*TODO*/ },
                        icon = (R.drawable.icon_linkedin)
                    )
                    IconOutlinedButton(
                        contentColor = LightColorTheme.brandColorDefault,
                        onClick = { /*TODO*/ },
                        icon = (R.drawable.icon_meta)
                    )
                }
            }
        }
    )
}