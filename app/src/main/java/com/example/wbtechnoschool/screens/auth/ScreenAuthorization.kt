package com.example.wbtechnoschool.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.search.FixTextField
import com.example.wbtechnoschool.utils.toggle.FixToggleSwitch
import com.example.wbtechnoschool.viewmodel.auth_view_model.AuthorizationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenAuthorization(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AuthorizationViewModel = koinViewModel(),
) {
    val number by viewModel.number.observeAsState("")
    val textColor = if (number.isEmpty()) LightColorTheme.neutralDisabled else Color.Black

    LaunchedEffect(number) {
        viewModel.onNumberChange(number)
    }

//    Column(
//        modifier =
//        modifier
//            .statusBarsPadding()
//            .fillMaxSize()
//            .padding(horizontal = MagicNumbers.SCREEN_AUTH_PROF_COLUMN_PADDING_HORIZONTAL.dp),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Spacer(modifier = Modifier.height(SPACER.SPACER_95.value.dp))
//        Text(
//            text = stringResource(id = R.string.enter_number_phone),
//            fontWeight = FontWeight.W700,
//            fontSize = MagicNumbers.SCREEN_AUTH_FONT_SIZE_ENTER_NUMBER_PHONE.sp,
//            fontFamily = fontSFPro,
//            color = LightColorTheme.neutralActive
//        )
//        Spacer(modifier = Modifier.height(SPACER.SPACER_15.value.dp))
//        Text(
//            text = stringResource(id = R.string.send_confirmation_code),
//            fontWeight = FontWeight.W400,
//            fontSize = MagicNumbers.SCREEN_AUTH_FONT_SIZE_SEND_CONFIRMATION_CODE.sp,
//            fontFamily = fontSFPro,
//            color = LightColorTheme.neutralActive,
//            textAlign = TextAlign.Center,
//            lineHeight = MagicNumbers.SCREEN_AUTH_LINE_HEIGHT_SEND_CONFIRMATION_CODE.sp
//        )
//        Spacer(modifier = Modifier.height(SPACER.SPACER_60.value.dp))
//        Row(
//            modifier =
//            Modifier
//                .fillMaxWidth()
//                .height(MagicNumbers.SCREEN_AUTH_HEIGHT_ROW_MODIFIER.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Box(
//                modifier =
//                Modifier
//                    .background(
//                        LightColorTheme.neutralSecondaryBG,
//                        RoundedCornerShape(MagicNumbers.SCREEN_AUTH_BOX_ROUNDED_CORNER_SHAPE.dp)
//                    )
//                    .width(MagicNumbers.SCREEN_AUTH_BOX_WIDTH_MODIFIER.dp)
//                    .fillMaxHeight()
//            ) {
//                Row(modifier = Modifier.padding(MagicNumbers.SCREEN_AUTH_ROW_MODIFIER_PADDING_PREFIX_TF.dp)) {
//                    PrefixNumberTextField(textColor)
//                }
//            }
//            Spacer(modifier = Modifier.width(MagicNumbers.SCREEN_AUTH_SPACER_WIDTH_TF.dp))
//            BasicTextField(
//                value = number,
//                onValueChange = { newNumber ->
//                    viewModel.onNumberChange(newNumber)
//                },
//                modifier =
//                Modifier
//                    .background(
//                        LightColorTheme.neutralSecondaryBG,
//                        RoundedCornerShape(MagicNumbers.SCREEN_AUTH_BASIC_TF_ROUNDED_CORNER_SHAPE_MODIFIER.dp)
//                    )
//                    .fillMaxHeight()
//                    .weight(MagicNumbers.SCREEN_AUTH_BASIC_WEIGHT_MODIFIER),
//                visualTransformation = PhoneNumberVisualTransformation(),
//                decorationBox = { innerTextField ->
//                    Box(
//                        contentAlignment = Alignment.CenterStart,
//                        modifier =
//                        Modifier.padding(
//                            horizontal = MagicNumbers.SCREEN_AUTH_DECORATION_BOX_MODIFIER_HORIZONTAL.dp,
//                            vertical = MagicNumbers.SCREEN_AUTH_DECORATION_BOX_MODIFIER_VERTICAL.dp
//                        )
//                    ) {
//                        if (number.isEmpty()) {
//                            Text(
//                                text = stringResource(id = R.string.placeholder_number),
//                                color = LightColorTheme.neutralDisabled,
//                                fontWeight = FontWeight.W600,
//                                fontSize = MagicNumbers.SCREEN_AUTH_DECORATION_BOX_TEXT_FONT_SIZE.sp,
//                                fontFamily = fontSFPro,
//                                letterSpacing = MagicNumbers.SCREEN_AUTH_DECORATION_BOX_TEXT_LETTER_SPACING.sp
//                            )
//                        }
//                        innerTextField()
//                    }
//                },
//                textStyle =
//                TextStyle(
//                    fontWeight = FontWeight.W600,
//                    fontSize = MagicNumbers.SCREEN_AUTH_BASIC_TF_TEXT_STYLE_FONT_SIZE.sp,
//                    fontFamily = fontSFPro,
//                    letterSpacing = MagicNumbers.SCREEN_AUTH_BASIC_TF_TEXT_STYLE_LETTER_SPACING.sp,
//                    color = LightColorTheme.neutralActive
//                ),
//                singleLine = true,
//                cursorBrush = SolidColor(LightColorTheme.neutralActive),
//                keyboardOptions =
//                KeyboardOptions.Default.copy(
//                    keyboardType = KeyboardType.Number
//                )
//            )
//        }
//        Spacer(modifier = Modifier.height(SPACER.SPACER_60.value.dp))
//        StatusButton(
//            containerColor = LightColorTheme.brandColorDefault,
//            enable = viewModel.numberValid(number),
//            onClick = {
//                navController.navigate("${Graph.EntryCode.route}/$number")
//            },
//            contentText = stringResource(id = R.string.resume),
//            modifier =
//            Modifier
//                .fillMaxWidth()
//                .height(MagicNumbers.SCREEN_AUTH_STATUS_BUTTON_MODIFIER_HEIGHT.dp)
//        )
//    }

    LazyColumn(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(horizontal = MagicNumbers.SCREEN_AUTH_PROF_COLUMN_PADDING_HORIZONTAL.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(1) {
            Text(text = "Фикс макета")
            FixTextField()
            FixToggleSwitch()
        }
    }
}

@Composable
fun PrefixNumberTextField(textColor: Color) {
    Image(
        painter = painterResource(id = R.drawable.icon_flag_russian),
        contentDescription = "",
        modifier =
        Modifier
            .size(MagicNumbers.PREF_NUMBER_TF_IMAGE_MODIFIER_SIZE.dp)
            .clip(RoundedCornerShape(MagicNumbers.PREF_NUMBER_TF_IMAGE_MODIFIER_CLIP.dp))
    )
    BasicTextField(
        value = "+7",
        onValueChange = {},
        singleLine = true,
        readOnly = true,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        modifier = Modifier.padding(start = MagicNumbers.PREF_NUMBER_TF_BASIC_TF_MODIFIER_PADDING_START.dp),
        textStyle =
        TextStyle(
            color = textColor,
            fontWeight = FontWeight.W600,
            fontSize = MagicNumbers.PREF_NUMBER_TF_BASIC_TF_TEXT_STYLE_FONT_SIZE.sp,
            fontFamily = fontSFPro
        )
    )
}
