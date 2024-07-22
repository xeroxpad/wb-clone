package com.example.wbtechnoschool.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.utils.button.StatusTextButton
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER
import com.example.wbtechnoschool.viewmodel.auth_view_model.EntryCodeViewModel
import org.koin.androidx.compose.koinViewModel

const val COUNTER_NUMBER = 4

@Composable
fun ScreenEntryCode(
    phoneNumber: String,
    navController: NavController,
    viewModel: EntryCodeViewModel = koinViewModel(),
) {
    val codeText by viewModel.codeText.observeAsState("")
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                iconBack = { navController.popBackStack() },
            )
        }, content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(horizontal = MagicNumbers.SCREEN_ENTRY_CODE_PADDING_HORIZONTAL.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(SPACER.SPACER_60.value.dp))
                Text(
                    text = stringResource(id = R.string.enter_code),
                    fontWeight = FontWeight.W700,
                    fontSize = MagicNumbers.SCREEN_ENTRY_CODE_TEXT_FONT_SIZE.sp,
                    fontFamily = fontSFPro,
                    color = LightColorTheme.neutralActive
                )
                Spacer(modifier = Modifier.height(SPACER.SPACER_15.value.dp))
                Text(
                    text = "${stringResource(id = R.string.sent_code_number)}\n+7 $phoneNumber",
                    fontWeight = FontWeight.W400,
                    fontSize = MagicNumbers.SCREEN_ENTRY_CODE_TEXT_REQUEST_CODE_FONT_SIZE.sp,
                    fontFamily = fontSFPro,
                    color = LightColorTheme.neutralActive,
                    textAlign = TextAlign.Center,
                    lineHeight = MagicNumbers.SCREEN_ENTRY_CODE_TEXT_LINE_HEIGHT.sp
                )
                EntryCode(
                    codeText = codeText,
                    numberEnter = { text, isComplete ->
                        viewModel.onCodeChange(text)
                        when {
                            isComplete -> {
                                navController.navigate(Graph.AuthorizationProfile.route) // пока для показа тут пример перехода
                            }
                        }
                    }
                )
                StatusTextButton(
                    contentColor = LightColorTheme.brandColorDefault,
                    containerColor = Color.Transparent,
                    enable = true,
                    onClick = { navController.navigate(Graph.AuthorizationProfile.route) }, // пока для показа тут пример перехода
                    contentText = stringResource(id = R.string.request_code_again),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MagicNumbers.SCREEN_ENTRY_CODE_STATUS_TEXT_BUTTON_HEIGHT.dp)
                )
            }
        }
    )
}

@Composable
fun NumberView(
    modifier: Modifier = Modifier,
    index: Int,
    text: String,
) {
    val char = when {
        index == text.length -> ""
        index > text.length -> ""
        else -> text[index].toString()
    }
    val contentColor = LightColorTheme.neutralActive
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(MagicNumbers.FUN_NUMBER_VIEW_BOX_HEIGHT.dp)
            .width(MagicNumbers.FUN_NUMBER_VIEW_BOX_WIDTH.dp)
            .background(Color.Transparent)
    ) {
        when {
            char.isNotEmpty() -> {
                Text(
                    text = char,
                    color = contentColor,
                    fontSize = MagicNumbers.FUN_NUMBER_VIEW_TEXT_IN_BOX_FONT_SIZE.sp,
                    fontWeight = FontWeight.W700
                )
            }

            else -> {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(MagicNumbers.FUN_NUMBER_VIEW_BOX_SIZE.dp)
                        .background(LightColorTheme.neutralLine)
                )
            }
        }
    }
}

@Composable
fun EntryCode(
    modifier: Modifier = Modifier,
    codeText: String,
    numberEnter: (String, Boolean) -> Unit,
) {
    BasicTextField(
        value = TextFieldValue(codeText, selection = TextRange(codeText.length)),
        onValueChange = {
            if (it.text.length <= COUNTER_NUMBER) {
                numberEnter.invoke(it.text, it.text.length == COUNTER_NUMBER)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier
                    .fillMaxWidth()
                    .padding(MagicNumbers.FUN_ENTRY_CODE_ROW_PADDING.dp)
            ) {
                repeat(COUNTER_NUMBER) { index ->
                    NumberView(
                        index = index,
                        text = codeText
                    )
                }
            }
        }
    )
}




