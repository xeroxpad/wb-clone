package com.example.wbtechnoschool.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.avatar.AddAvatarProfile
import com.example.wbtechnoschool.utils.button.StatusButton
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER
import com.example.wbtechnoschool.utils.search.CustomTextFieldForProfile
import com.example.wbtechnoschool.viewmodel.auth_view_model.AuthorizationProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenAuthorizationProfile(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AuthorizationProfileViewModel = koinViewModel(),
) {
    val name by viewModel.name.collectAsState()
    val surname by viewModel.surname.collectAsState()

    LaunchedEffect(name) {
        viewModel.nameChange(name)
    }
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = stringResource(id = R.string.top_bar_profile),
                iconBack = { navController.popBackStack() },
            )
        },
        content = { innerPadding ->
            Column(
                modifier =
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(horizontal = MagicNumbers.SCREEN_AUTH_PROF_COLUMN_PADDING_HORIZONTAL.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(SPACER.SPACER_60.value.dp))
                AddAvatarProfile()
                Spacer(modifier = Modifier.height(SPACER.SPACER_30.value.dp))
                CustomTextFieldForProfile(
                    textPlaceholder = stringResource(id = R.string.text_placeholder_name),
                    text = name,
                    textChange = { viewModel.nameChange(it) }
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
                CustomTextFieldForProfile(
                    textPlaceholder = stringResource(id = R.string.text_placeholder_surname),
                    text = surname,
                    textChange = { viewModel.surnameChange(it) }
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_40.value.dp))
//                StatusButton(
////                    containerColor = LightColorTheme.brandColorDefault,
////                    enable = name.isNotEmpty(),
//                    onClick = { viewModel.saveDataProfile(navController) }, // пока для показа тут пример перехода
//                    contentText = stringResource(id = R.string.save),
//                    modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .height(MagicNumbers.SCREEN_AUTH_PROF_STATUS_BUTTON_HEIGHT.dp)
//                )
            }
        }
    )
}
