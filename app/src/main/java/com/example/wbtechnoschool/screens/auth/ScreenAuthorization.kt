package com.example.wbtechnoschool.screens.auth

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
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
import com.example.wbtechnoschool.utils.avatar.FixRowAvatars
import com.example.wbtechnoschool.utils.button.PaymentButton
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.search.FieldForNumber
import com.example.wbtechnoschool.utils.search.FixTextField
import com.example.wbtechnoschool.utils.toggle.FixToggleSwitch
import com.example.wbtechnoschool.viewmodel.auth_view_model.AuthorizationViewModel
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenAuthorization(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AuthorizationViewModel = koinViewModel(),
) {
    val number by viewModel.number.observeAsState("")
    val textColor = if (number.isEmpty()) LightColorTheme.neutralDisabled else Color.Black
    val focusManager = LocalFocusManager.current

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
            .pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            }
            .padding(horizontal = MagicNumbers.SCREEN_AUTH_PROF_COLUMN_PADDING_HORIZONTAL.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(1) {
            Text(text = "Фикс макета")
            Spacer(modifier = Modifier.height(10.dp))
//            FixTextField(placeholder = R.string.name_and_second_name)
            Spacer(modifier = Modifier.height(10.dp))
//            FieldForNumber {}
            Spacer(modifier = Modifier.height(10.dp))
            FixToggleSwitch()
            Spacer(modifier = Modifier.height(10.dp))
            FixRowAvatars(
                arrayImage = listOf(
                    "https://img.freepik.com/free-photo/river-surrounded-by-forests-under-a-cloudy-sky-in-thuringia-in-germany_181624-30863.jpg?w=2000&t=st=1721590773~exp=1721591373~hmac=8bafe832f555c2d27e0eb6104a156a05517526716799a7f7329d7a3ed3ad5fda",
                    "https://img.freepik.com/free-photo/view-of-beautiful-rainbow-over-nature-landscape_23-2151597605.jpg?w=1800&t=st=1721590788~exp=1721591388~hmac=8271a7c5930c7fdb083c5e7320c77c065cf369231c67a0d023285f352a3118ee",
                    "https://img.freepik.com/free-photo/mountains-lake_1398-1153.jpg?w=1800&t=st=1721590799~exp=1721591399~hmac=d0f17dbaba1f0dfe86eb81e1ea40e8411da39d0fe3e87343773c74a7381dca05",
                    "https://img.freepik.com/free-photo/vertical-landscape-with-mountains-lake_1398-3441.jpg?w=1800&t=st=1721590816~exp=1721591416~hmac=57c4ee8e445680e70baea9e6f29a83a917b0579ad40193b0b18396bac22220f6",
                    "https://img.freepik.com/free-photo/photorealistic-tree-with-branches-and-trunk-outside-in-nature_23-2151478150.jpg?w=1800&t=st=1721590832~exp=1721591432~hmac=0c503568d6e3f627ece66975db2c1c11b2af0daa91c59012c5592c388279c583",
                    "https://img.freepik.com/free-photo/vertical-landscape-with-mountains-lake_1398-3441.jpg?w=1800&t=st=1721590816~exp=1721591416~hmac=57c4ee8e445680e70baea9e6f29a83a917b0579ad40193b0b18396bac22220f6",
                    "https://img.freepik.com/free-photo/photorealistic-tree-with-branches-and-trunk-outside-in-nature_23-2151478150.jpg?w=1800&t=st=1721590832~exp=1721591432~hmac=0c503568d6e3f627ece66975db2c1c11b2af0daa91c59012c5592c388279c583",
                    "https://img.freepik.com/free-photo/vertical-landscape-with-mountains-lake_1398-3441.jpg?w=1800&t=st=1721590816~exp=1721591416~hmac=57c4ee8e445680e70baea9e6f29a83a917b0579ad40193b0b18396bac22220f6",
                    "https://img.freepik.com/free-photo/photorealistic-tree-with-branches-and-trunk-outside-in-nature_23-2151478150.jpg?w=1800&t=st=1721590832~exp=1721591432~hmac=0c503568d6e3f627ece66975db2c1c11b2af0daa91c59012c5592c388279c583",
                    "https://img.freepik.com/free-photo/vertical-landscape-with-mountains-lake_1398-3441.jpg?w=1800&t=st=1721590816~exp=1721591416~hmac=57c4ee8e445680e70baea9e6f29a83a917b0579ad40193b0b18396bac22220f6",
                    "https://img.freepik.com/free-photo/river-surrounded-by-forests-under-a-cloudy-sky-in-thuringia-in-germany_181624-30863.jpg?w=2000&t=st=1721590773~exp=1721591373~hmac=8bafe832f555c2d27e0eb6104a156a05517526716799a7f7329d7a3ed3ad5fda",
                    "https://img.freepik.com/free-photo/view-of-beautiful-rainbow-over-nature-landscape_23-2151597605.jpg?w=1800&t=st=1721590788~exp=1721591388~hmac=8271a7c5930c7fdb083c5e7320c77c065cf369231c67a0d023285f352a3118ee",
                    "https://img.freepik.com/free-photo/mountains-lake_1398-1153.jpg?w=1800&t=st=1721590799~exp=1721591399~hmac=d0f17dbaba1f0dfe86eb81e1ea40e8411da39d0fe3e87343773c74a7381dca05",
                    "https://img.freepik.com/free-photo/vertical-landscape-with-mountains-lake_1398-3441.jpg?w=1800&t=st=1721590816~exp=1721591416~hmac=57c4ee8e445680e70baea9e6f29a83a917b0579ad40193b0b18396bac22220f6",
                    "https://img.freepik.com/free-photo/photorealistic-tree-with-branches-and-trunk-outside-in-nature_23-2151478150.jpg?w=1800&t=st=1721590832~exp=1721591432~hmac=0c503568d6e3f627ece66975db2c1c11b2af0daa91c59012c5592c388279c583",
                    "https://img.freepik.com/free-photo/vertical-landscape-with-mountains-lake_1398-3441.jpg?w=1800&t=st=1721590816~exp=1721591416~hmac=57c4ee8e445680e70baea9e6f29a83a917b0579ad40193b0b18396bac22220f6",
                    "https://img.freepik.com/free-photo/photorealistic-tree-with-branches-and-trunk-outside-in-nature_23-2151478150.jpg?w=1800&t=st=1721590832~exp=1721591432~hmac=0c503568d6e3f627ece66975db2c1c11b2af0daa91c59012c5592c388279c583",
                    "https://img.freepik.com/free-photo/vertical-landscape-with-mountains-lake_1398-3441.jpg?w=1800&t=st=1721590816~exp=1721591416~hmac=57c4ee8e445680e70baea9e6f29a83a917b0579ad40193b0b18396bac22220f6",
                    "https://img.freepik.com/free-photo/photorealistic-tree-with-branches-and-trunk-outside-in-nature_23-2151478150.jpg?w=1800&t=st=1721590832~exp=1721591432~hmac=0c503568d6e3f627ece66975db2c1c11b2af0daa91c59012c5592c388279c583",
                    "https://img.freepik.com/free-photo/vertical-landscape-with-mountains-lake_1398-3441.jpg?w=1800&t=st=1721590816~exp=1721591416~hmac=57c4ee8e445680e70baea9e6f29a83a917b0579ad40193b0b18396bac22220f6",
                ),
            ) {}
            Spacer(modifier = Modifier.height(10.dp))
            PaymentButton(
                background = listOf(
                    LightColorTheme.fixBlushPink,
                    LightColorTheme.fixFuchsiaGlow,
                    LightColorTheme.fixVividViolet,
                    LightColorTheme.fixElectricViolet,
                    LightColorTheme.fixRadiantMagenta,
                    LightColorTheme.fixVioletBlaze,
                    LightColorTheme.fixNeonLavender,
                    LightColorTheme.fixRoyalIndigo
                ),
                enable = true,
                onClick = { /*TODO*/ },
                contentText = "Оплатить",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(MagicNumbers.BUTTON_SHAPE))
                    .fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.icon_habr),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.icon_telegram),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
//            FixCardCommunity(
//                onClick = { /*TODO*/ },
//                event = FixEvent(
//                    1,
//                    "https://yandex.ru/images/search?cbir_id=3536093%2Fz2xHZPylwdLhvw1pXq50Fw3905&cbir_page=similar&crop=0.016%3B0.016%3B0.984%3B0.984&img_url=https%3A%2F%2Fucare.timepad.ru%2F2d8cb8b2-a1e4-43f4-a414-1e6dc76c67a9%2Fposter_event_1532412.jpg&lr=10748&pos=0&rpt=imageview&url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-images-cbir%2F3536093%2Fz2xHZPylwdLhvw1pXq50Fw3905%2Forig",
//                    "Python days 2024"
//                )
//            )
        }
    }
}

@Composable
fun PrefixNumberTextField(modifier: Modifier = Modifier, textColor: Color) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_flag_russian),
            contentDescription = null,
            modifier =
            Modifier
                .size(MagicNumbers.PREF_NUMBER_TF_IMAGE_MODIFIER_SIZE.dp)
                .clip(RoundedCornerShape(MagicNumbers.PREF_NUMBER_TF_IMAGE_MODIFIER_CLIP.dp))
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "+7",
            color = textColor,
            fontWeight = FontWeight.W600,
            fontSize = MagicNumbers.PREF_NUMBER_TF_BASIC_TF_TEXT_STYLE_FONT_SIZE.sp,
            fontFamily = fontSFPro
        )
    }
}

